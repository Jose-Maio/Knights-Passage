package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.DungeonEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonEnemyTest {

    private DungeonEnemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new DungeonEnemy(new Position(10, 10), 15, 4);
    }

    @Test
    void testConstructor() {
        assertEquals(15, enemy.getMaxHealth());
        assertEquals(4, enemy.getDamage());
    }

    @Test
    void testMovement() {
        enemy.move(Direction.DOWN);
        assertEquals(10, enemy.getPosition().getX());
        assertEquals(11, enemy.getPosition().getY());
    }

    @Test
    void testHealth() {
        enemy.takeDamage(10);
        assertEquals(5, enemy.getHealth());
    }

    @Test
    void testToStringImg() {
        enemy.setFacing(Direction.DOWN);
        assertTrue(enemy.toStringImg().contains("DungeonEnemy"));
    }
}
