package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.enemies.ForestEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ForestEnemyTest {

    private ForestEnemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new ForestEnemy(new Position(10, 10), 15, 4);
    }

    @Test
    void testConstructor() {
        assertEquals(15, enemy.getMaxHealth());
        assertEquals(15, enemy.getHealth());
        assertEquals(4, enemy.getDamage());
    }

    @Test
    void testMovement() {
        enemy.move(Direction.UP);
        assertEquals(10, enemy.getPosition().getX());
        assertEquals(9, enemy.getPosition().getY());
    }

    @Test
    void testHealth() {
        enemy.takeDamage(10);
        assertEquals(5, enemy.getHealth());
        assertFalse(enemy.isDead());

        enemy.takeDamage(10);
        assertTrue(enemy.isDead());
    }


    @Test
    void testToStringImg() {
        enemy.setFacing(Direction.RIGHT);
        assertTrue(enemy.toStringImg().contains("ForestEnemy"));
        assertTrue(enemy.toStringImg().contains("right"));
    }
}
