package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.ForestEnemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForestEnemyTest {

    @Test
    void testConstructor() {
        Position pos = new Position(10, 10);
        ForestEnemy enemy = new ForestEnemy(pos, 50, 5);

        assertEquals(pos, enemy.getPosition());
        assertEquals(50, enemy.getHealth());
        assertEquals(5, enemy.getDamage());
    }

    @Test
    void testToStringImg() {
        ForestEnemy enemy = new ForestEnemy(new Position(0, 0), 100, 10);

        enemy.setFacing(Direction.LEFT);
        enemy.setAttacking(false);
        assertEquals("ForestEnemy left", enemy.toStringImg());

        enemy.setFacing(Direction.RIGHT);
        enemy.setAttacking(true);
        assertEquals("ForestEnemy right attack", enemy.toStringImg());

        enemy.setFacing(Direction.DOWN);
        enemy.setAttacking(false);
        assertEquals("ForestEnemy front", enemy.toStringImg());

        enemy.setFacing(Direction.UP);
        assertEquals("ForestEnemy back", enemy.toStringImg());

        enemy.setFacing(null);
        assertEquals("ForestEnemy ", enemy.toStringImg());

        enemy.setAttacking(true);
        assertEquals("ForestEnemy  attack", enemy.toStringImg());
    }
}