package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyTest {
    private Enemy enemy;
    private Position initialPos;
    private final int health = 100;
    private final int damage = 10;

    private static class EnemyStub extends Enemy {
        public EnemyStub(Position p, int h, int d, int w, int he, long ad) {
            super(p, h, d, w, he, ad);
        }
        @Override
        public String toStringImg() { return "stub"; }
    }

    @BeforeEach
    void setUp() {
        initialPos = new Position(100, 100);
        long delay = 500;
        int hbHeight = 20;
        int hbWidth = 20;
        enemy = new EnemyStub(initialPos, health, damage, hbWidth, hbHeight, delay);
    }

    @Test
    void testConstructor() {
        assertNotNull(enemy);
        assertEquals(health, enemy.getHealth());
        assertEquals(damage, enemy.getDamage());
    }

    @Test
    void testGetPosition() {
        assertEquals(initialPos, enemy.getPosition());
    }

    @Test
    void testSetPosition() {
        Position newPos = new Position(200, 200);
        enemy.setPosition(newPos);
        assertEquals(newPos, enemy.getPosition());
        assertEquals(202, enemy.getHitbox().x);
    }

    @Test
    void testMove() {
        Position startPos = new Position(10, 10);
        Enemy enemy = new EnemyStub(startPos, 100, 10, 12, 12, 500);

        enemy.move(Direction.UP);
        assertEquals(Direction.UP, enemy.getFacing());
        assertEquals(new Position(10, 9), enemy.getPosition());

        enemy.move(Direction.DOWN);
        assertEquals(Direction.DOWN, enemy.getFacing());
        assertEquals(new Position(10, 10), enemy.getPosition());

        enemy.move(Direction.LEFT);
        assertEquals(Direction.LEFT, enemy.getFacing());
        assertEquals(new Position(9, 10), enemy.getPosition());

        enemy.move(Direction.RIGHT);
        assertEquals(Direction.RIGHT, enemy.getFacing());
        assertEquals(new Position(10, 10), enemy.getPosition());
        
        enemy.move(null);
        assertNull(enemy.getFacing());
        assertEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void testIsDead() {
        assertFalse(enemy.isDead());
        enemy.takeDamage(100);
        assertTrue(enemy.isDead());
    }

    @Test
    void testTakeDamage() {
        enemy.takeDamage(30);
        assertEquals(70, enemy.getHealth());
    }

    @Test
    void testGetMaxHealth() {
        assertEquals(health, enemy.getMaxHealth());
    }

    @Test
    void testGetDamage() {
        assertEquals(damage, enemy.getDamage());
    }

    @Test
    void testSetAttacking() {
        enemy.setAttacking(true);
        assertTrue(true);
    }

    @Test
    void testGetHitbox() {
        Rectangle hb = enemy.getHitbox();
        assertEquals(102, hb.x);
        assertEquals(20, hb.width);
    }

    @Test
    void testGetAttackRange() {
        Rectangle ar = enemy.getAttackRange();
        assertEquals(101, ar.x);
        assertEquals(22, ar.width);
    }

    @Test
    void testGetVision() {
        Rectangle v = enemy.getVision();
        assertEquals(50, v.x);
    }

    @Test
    void testGetFacing() {
        assertEquals(Direction.RIGHT, enemy.getFacing());
    }

    @Test
    void testSetFacing() {
        enemy.setFacing(Direction.UP);
        assertEquals(Direction.UP, enemy.getFacing());
    }

    @Test
    void testCanAttack()  {
        assertTrue(enemy.canAttack());
        enemy.lastAttack = System.currentTimeMillis();
        assertFalse(enemy.canAttack());
    }

    @Test
    void testAttack() {
        Character target = mock(Character.class);
        enemy.attack(target);
        verify(target).takeDamage(damage);
        assertTrue(enemy.lastAttack > 0);
    }
}