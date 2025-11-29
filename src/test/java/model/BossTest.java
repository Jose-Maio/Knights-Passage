package model;

import model.entities.characters.enemies.Boss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    private Boss boss;

    @BeforeEach
    void setUp() {
        boss = new Boss(new Position(10, 10), 50, 8);
    }

    @Test
    void testInitialValues() {
        assertEquals(10, boss.getPosition().getX());
        assertEquals(10, boss.getPosition().getY());
        assertFalse(boss.isDead());
    }

    @Test
    void testMove() {
        boss.move(Direction.UP);
        assertEquals(10, boss.getPosition().getX());
        assertEquals(9, boss.getPosition().getY());

        boss.move(Direction.LEFT);
        assertEquals(9, boss.getPosition().getX());
        assertEquals(9, boss.getPosition().getY());
    }

    @Test
    void testTakeDamage() {
        boss.takeDamage(20);
        assertFalse(boss.isDead());

        boss.takeDamage(40);
        assertTrue(boss.isDead());
    }

    @Test
    void testNoCustomUpdateBehavior() {
        assertDoesNotThrow(() -> boss.update());
    }
}
