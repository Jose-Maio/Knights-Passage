package controller_test;

import controller.managers.CollisionManager;
import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Rectangle;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollisionManagerTest {

    private CollisionManager collisionManager;
    private Level mockLevel;
    private Player mockPlayer;
    private model.game.Arena mockArena;

    @BeforeEach
    void setUp() {
        collisionManager = new CollisionManager();
        mockLevel = mock(Level.class);
        mockPlayer = mock(Player.class);
        mockArena = mock(model.game.Arena.class);

        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getCloseEnemyList()).thenReturn(new ArrayList<>());
        when(mockLevel.getEnemyList()).thenReturn(new ArrayList<>());
    }

    @Test
    void testGetCollisionSide() {
        when(mockPlayer.getAttackRange()).thenReturn(new Rectangle(10, 10, 20, 20));
        model.entities.characters.enemies.Enemy mockEnemy = mock(model.entities.characters.enemies.Enemy.class);
        when(mockEnemy.getHitbox()).thenReturn(new Rectangle(15, 15, 10, 10));

        Direction side = collisionManager.getCollisionSide(mockPlayer, mockEnemy);
        assertNotNull(side);
    }

    @Test
    void testGetCollisionSideNoIntersection() {
        when(mockPlayer.getAttackRange()).thenReturn(new Rectangle(10, 10, 20, 20));
        model.entities.characters.enemies.Enemy mockEnemy = mock(model.entities.characters.enemies.Enemy.class);
        when(mockEnemy.getHitbox()).thenReturn(new Rectangle(100, 100, 10, 10));

        Direction side = collisionManager.getCollisionSide(mockPlayer, mockEnemy);
        assertNull(side);
    }

    @Test
    void testCheckPlayerCollisions() {
        Position position = new Position(10, 10);
        when(mockArena.getAllObjectList()).thenReturn(new ArrayList<>());
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);

        boolean collision = collisionManager.checkPlayerCollisions(position, mockLevel);
        assertFalse(collision);
    }

    @Test
    void testCheckEnemyCollisions() {
        Position position = new Position(10, 10);
        model.entities.characters.enemies.Enemy mockEnemy = mock(model.entities.characters.enemies.Enemy.class);
        when(mockEnemy.getHitbox()).thenReturn(new Rectangle(10, 10, 12, 12));
        when(mockArena.getAllObjectList()).thenReturn(new ArrayList<>());
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(20, 20, 12, 12));

        boolean collision = collisionManager.checkEnemyCollisions(position, mockEnemy, mockLevel);
        assertFalse(collision);
    }
}
