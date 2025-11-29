package model_tests;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {


    static class TestEnemy extends Enemy {
        public TestEnemy(Position position, int health, int damage) {
            super(position, health, damage);
        }
    }

    private TestEnemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new TestEnemy(new Position(5, 5), 10, 3);
    }

    @Test
    void testInitialValues() {
        assertEquals(5, enemy.getPosition().getX());
        assertEquals(5, enemy.getPosition().getY());
        assertFalse(enemy.isDead());
    }

    @Test
    void testMoveUp() {
        enemy.move(Direction.UP);
        assertEquals(5, enemy.getPosition().getX());
        assertEquals(4, enemy.getPosition().getY());
    }

    @Test
    void testMoveDown() {
        enemy.move(Direction.DOWN);
        assertEquals(5, enemy.getPosition().getX());
        assertEquals(6, enemy.getPosition().getY());
    }

    @Test
    void testMoveLeft() {
        enemy.move(Direction.LEFT);
        assertEquals(4, enemy.getPosition().getX());
        assertEquals(5, enemy.getPosition().getY());
    }

    @Test
    void testMoveRight() {
        enemy.move(Direction.RIGHT);
        assertEquals(6, enemy.getPosition().getX());
        assertEquals(5, enemy.getPosition().getY());
    }

    @Test
    void testTakeDamage() {
        enemy.takeDamage(4);
        assertFalse(enemy.isDead());
        enemy.takeDamage(6);
        assertTrue(enemy.isDead());
    }

    @Test
    void testIsDeadInitial() {
        TestEnemy e = new TestEnemy(new Position(0,0), 0, 1);
        assertTrue(e.isDead());
    }

    @Test
    void testUpdateDoesNotThrow() {
        assertDoesNotThrow(() -> enemy.update());
    }
}
