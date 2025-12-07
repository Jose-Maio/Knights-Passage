package model;


import model.entities.characters.enemies.DungeonEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonEnemyTest {

    private DungeonEnemy dungeonEnemy;

    @BeforeEach
    void setUp() {
        dungeonEnemy = new DungeonEnemy(new Position(2, 3), 15, 4);
    }

    @Test
    void testInitialValues() {
        assertEquals(2, dungeonEnemy.getPosition().getX());
        assertEquals(3, dungeonEnemy.getPosition().getY());
        assertFalse(dungeonEnemy.isDead());
    }

    @Test
    void testMovement() {
        dungeonEnemy.move(Direction.UP);
        assertEquals(2, dungeonEnemy.getPosition().getX());
        assertEquals(2, dungeonEnemy.getPosition().getY());

        dungeonEnemy.move(Direction.LEFT);
        assertEquals(1, dungeonEnemy.getPosition().getX());
        assertEquals(2, dungeonEnemy.getPosition().getY());
    }

    @Test
    void testTakeDamage() {
        dungeonEnemy.takeDamage(5);
        assertFalse(dungeonEnemy.isDead());

        dungeonEnemy.takeDamage(20);
        assertTrue(dungeonEnemy.isDead());
    }

    @Test
    void testNoCustomUpdateBehavior() {
       // assertDoesNotThrow(() -> dungeonEnemy.update());
    }
}
