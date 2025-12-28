package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.CastleEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastleEnemyTest {

    private CastleEnemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new CastleEnemy(new Position(10, 10), 20, 5);
    }

    @Test
    void testConstructor() {
        assertEquals(20, enemy.getMaxHealth());
        assertEquals(5, enemy.getDamage());
    }

    @Test
    void testMovement() {
        enemy.move(Direction.LEFT);
        assertEquals(9, enemy.getPosition().getX());
        assertEquals(10, enemy.getPosition().getY());
    }

    @Test
    void testHealth() {
        enemy.takeDamage(15);
        assertEquals(5, enemy.getHealth());
        assertFalse(enemy.isDead());
    }

    @Test
    void testToStringImg() {
        enemy.setFacing(Direction.LEFT);
        assertTrue(enemy.toStringImg().contains("CastleEnemy"));
    }
}
