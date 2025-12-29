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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovementManagerTest {

    private MovementManager movementManager;
    private Level mockLevel;
    private Player mockPlayer;
    private Arena mockArena;
    private Enemy mockEnemy;

    @BeforeEach
    void setUp() {
        movementManager = new MovementManager();
        mockLevel = mock(Level.class);
        mockPlayer = mock(Player.class);
        mockArena = mock(Arena.class);
        mockEnemy = mock(Enemy.class);

        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getCloseEnemyList()).thenReturn(new ArrayList<>());
        when(mockLevel.getEnemyList()).thenReturn(new ArrayList<>());
        when(mockArena.getAllObjectList()).thenReturn(new ArrayList<>());
        when(mockArena.isInsideArena(any(java.awt.Rectangle.class))).thenReturn(true);

        when(mockEnemy.getPosition()).thenReturn(new Position(5, 5));
        when(mockEnemy.nextPos(any(Direction.class))).thenReturn(new Position(6, 5));
        when(mockEnemy.getHitbox()).thenReturn(new java.awt.Rectangle(5, 5, 12, 12));
        when(mockEnemy.getVision()).thenReturn(new java.awt.Rectangle(0, 0, 100, 100));
    }

    @Test
    void testMovePlayer() {
        when(mockPlayer.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.nextPos(Direction.RIGHT)).thenReturn(new Position(11, 10));
        when(mockPlayer.getHitbox()).thenReturn(new java.awt.Rectangle(10, 10, 12, 12));

        assertDoesNotThrow(() -> movementManager.movePlayer(mockLevel, Direction.RIGHT));
        verify(mockPlayer).move(Direction.RIGHT);
    }

    @Test
    void testMovePlayerNullDirection() {
        assertDoesNotThrow(() -> movementManager.movePlayer(mockLevel, null));
        verify(mockPlayer, never()).move(any());
    }

    @Test
    void testMoveEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy);
        when(mockLevel.getCloseEnemyList()).thenReturn(enemies);
        when(mockPlayer.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.getHitbox()).thenReturn(new java.awt.Rectangle(10, 10, 12, 12));

        assertDoesNotThrow(() -> movementManager.moveEnemies(mockLevel));
        verify(mockEnemy, atLeastOnce()).getPosition();
    }
}
