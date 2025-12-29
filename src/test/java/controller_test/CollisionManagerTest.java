package controller_test;

import controller.managers.CollisionManager;
import model.Direction;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Object;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollisionManagerTest {
    private CollisionManager collisionManager;
    private Level mockLevel;
    private Arena mockArena;
    private Player mockPlayer;

    @BeforeEach
    void setUp() {
        collisionManager = new CollisionManager();
        mockLevel = mock(Level.class);
        mockArena = mock(Arena.class);
        mockPlayer = mock(Player.class);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
    }

    @Test
    void testGetCollisionSideNull() {
        Character attacker = mock(Character.class);
        Character target = mock(Character.class);
        when(attacker.getAttackRange()).thenReturn(new Rectangle(0, 0, 10, 10));
        when(target.getHitbox()).thenReturn(new Rectangle(50, 50, 10, 10));

        assertNull(collisionManager.getCollisionSide(attacker, target));
    }

    @Test
    void testGetCollisionSideDirections() {
        Character attacker = mock(Character.class);
        Character target = mock(Character.class);

        when(attacker.getAttackRange()).thenReturn(new Rectangle(0, 0, 10, 10));
        when(target.getHitbox()).thenReturn(new Rectangle(-2, 0, 10, 10));
        assertEquals(Direction.LEFT, collisionManager.getCollisionSide(attacker, target));

        when(target.getHitbox()).thenReturn(new Rectangle(2, 0, 10, 10));
        assertEquals(Direction.RIGHT, collisionManager.getCollisionSide(attacker, target));

        when(target.getHitbox()).thenReturn(new Rectangle(0, -2, 10, 10));
        assertEquals(Direction.UP, collisionManager.getCollisionSide(attacker, target));

        when(target.getHitbox()).thenReturn(new Rectangle(0, 2, 10, 10));
        assertEquals(Direction.DOWN, collisionManager.getCollisionSide(attacker, target));
    }

    @Test
    void testCheckPlayerCollisions() {
        Position pos = new Position(10, 10);
        Object solidObj = mock(Object.class);
        Enemy closeEnemy = mock(Enemy.class);

        when(mockArena.getAllObjectList()).thenReturn(Collections.singletonList(solidObj));
        when(mockLevel.getCloseEnemyList()).thenReturn(Collections.singletonList(closeEnemy));
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);


        when(solidObj.isSolid()).thenReturn(true);
        when(solidObj.getHitbox()).thenReturn(new Rectangle(10, 10, 32, 32));
        assertTrue(collisionManager.checkPlayerCollisions(pos, mockLevel));


        when(solidObj.isSolid()).thenReturn(false);
        when(closeEnemy.getHitbox()).thenReturn(new Rectangle(10, 10, 32, 32));
        assertTrue(collisionManager.checkPlayerCollisions(pos, mockLevel));


        when(closeEnemy.getHitbox()).thenReturn(new Rectangle(500, 500, 1, 1));
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(false);
        assertTrue(collisionManager.checkPlayerCollisions(pos, mockLevel));


        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);
        assertFalse(collisionManager.checkPlayerCollisions(pos, mockLevel));
    }

    @Test
    void testCheckEnemyCollisions() {
        Position pos = new Position(10, 10);
        Enemy self = mock(Enemy.class);
        Enemy other = mock(Enemy.class);
        Object solidObj = mock(Object.class);

        when(self.getHitbox()).thenReturn(new Rectangle(0, 0, 10, 10));
        when(other.getHitbox()).thenReturn(new Rectangle(10, 10, 10, 10));
        when(mockLevel.getEnemyList()).thenReturn(Arrays.asList(self, other));
        when(mockArena.getAllObjectList()).thenReturn(Collections.singletonList(solidObj));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(500, 500, 1, 1));
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);

        when(solidObj.isSolid()).thenReturn(true);
        when(solidObj.getHitbox()).thenReturn(new Rectangle(10, 10, 10, 10));
        assertTrue(collisionManager.checkEnemyCollisions(pos, self, mockLevel));

        when(solidObj.isSolid()).thenReturn(false);
        assertTrue(collisionManager.checkEnemyCollisions(pos, self, mockLevel));

        when(mockLevel.getEnemyList()).thenReturn(Collections.singletonList(self));
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(10, 10, 10, 10));
        assertTrue(collisionManager.checkEnemyCollisions(pos, self, mockLevel));

        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(500, 500, 1, 1));
        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(false);
        assertTrue(collisionManager.checkEnemyCollisions(pos, self, mockLevel));

        when(mockArena.isInsideArena(any(Rectangle.class))).thenReturn(true);
        assertFalse(collisionManager.checkEnemyCollisions(pos, self, mockLevel));
    }
}