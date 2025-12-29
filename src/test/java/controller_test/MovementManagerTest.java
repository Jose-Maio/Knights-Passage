package controller_test;

import controller.managers.MovementManager;
import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class MovementManagerTest {
    private MovementManager movementManager;
    private Level mockLevel;
    private Arena mockArena;
    private Player mockPlayer;
    private Enemy mockEnemy;

    @BeforeEach
    void setUp() {
        movementManager = new MovementManager();
        mockLevel = mock(Level.class);
        mockArena = mock(Arena.class);
        mockPlayer = mock(Player.class);
        mockEnemy = mock(Enemy.class);

        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);

        when(mockArena.getAllObjectList()).thenReturn(Collections.emptyList());
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);
    }


    @Test
    void testMovePlayerSuccess() {
        Position nextPos = new Position(10, 10);
        when(mockPlayer.nextPos(Direction.UP)).thenReturn(nextPos);

        when(mockLevel.getCloseEnemyList()).thenReturn(Collections.emptyList());

        movementManager.movePlayer(mockLevel, Direction.UP);

        verify(mockPlayer).move(Direction.UP);
    }

    @Test
    void testMovePlayerBlockedByArenaBounds() {
        Position nextPos = new Position(10, 10);
        when(mockPlayer.nextPos(Direction.UP)).thenReturn(nextPos);

        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(false);

        movementManager.movePlayer(mockLevel, Direction.UP);

        verify(mockPlayer, never()).move(any());
        verify(mockPlayer).setFacing(Direction.UP);
    }

    @Test
    void testMovePlayerNullDirection() {
        movementManager.movePlayer(mockLevel, null);
        verify(mockPlayer, never()).move(any());
    }


    @Test
    void testMoveEnemiesCalculations() {
        when(mockLevel.getCloseEnemyList()).thenReturn(List.of(mockEnemy));
        when(mockLevel.getEnemyList()).thenReturn(List.of(mockEnemy));
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);

        Arena mockArena = mock(Arena.class);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockArena.getAllObjectList()).thenReturn(Collections.emptyList());
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);

        when(mockEnemy.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.getPosition()).thenReturn(new Position(20, 15));

        Rectangle enemyHitbox = new Rectangle(11, 10, 1, 1);
        when(mockEnemy.getHitbox()).thenReturn(enemyHitbox);
        when(mockEnemy.nextPos(Direction.RIGHT)).thenReturn(new Position(11, 10));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(100, 100, 1, 1));

        movementManager.moveEnemies(mockLevel);

        verify(mockEnemy).move(Direction.RIGHT);
    }

    @Test
    void testMoveEnemiesVerticalPriority() {
        when(mockLevel.getCloseEnemyList()).thenReturn(List.of(mockEnemy));
        when(mockLevel.getEnemyList()).thenReturn(List.of(mockEnemy));
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);

        Arena mockArena = mock(Arena.class);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockArena.getAllObjectList()).thenReturn(Collections.emptyList());
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);

        when(mockEnemy.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.getPosition()).thenReturn(new Position(12, 20));

        Rectangle enemyHitbox = new Rectangle(10, 11, 1, 1);
        when(mockEnemy.getHitbox()).thenReturn(enemyHitbox);
        when(mockEnemy.nextPos(Direction.DOWN)).thenReturn(new Position(10, 11));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(100, 100, 1, 1));

        movementManager.moveEnemies(mockLevel);

        verify(mockEnemy).move(Direction.DOWN);
    }

    @Test
    void testMoveEnemyBlockedByPlayer() {
        when(mockEnemy.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.getPosition()).thenReturn(new Position(12, 10));
        when(mockLevel.getCloseEnemyList()).thenReturn(List.of(mockEnemy));

        Position nextPos = new Position(11, 10);
        when(mockEnemy.nextPos(Direction.RIGHT)).thenReturn(nextPos);
        when(mockEnemy.getHitbox()).thenReturn(new Rectangle(11, 10, 32, 32));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(11, 10, 32, 32));
        when(mockLevel.getEnemyList()).thenReturn(List.of(mockEnemy));

        movementManager.moveEnemies(mockLevel);

        verify(mockEnemy, never()).move(any());
        verify(mockEnemy).setFacing(Direction.RIGHT);
    }
}