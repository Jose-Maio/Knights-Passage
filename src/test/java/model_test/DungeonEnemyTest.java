package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.DungeonEnemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonEnemyTest {

    @Test
    void testConstructor() {
        Position pos = new Position(20, 30);
        DungeonEnemy enemy = new DungeonEnemy(pos, 80, 15);

        assertEquals(pos, enemy.getPosition());
        assertEquals(80, enemy.getHealth());
        assertEquals(15, enemy.getDamage());
    }

    @Test
    void testToStringImg() {
        DungeonEnemy enemy = new DungeonEnemy(new Position(0, 0), 100, 10);

        enemy.setFacing(Direction.LEFT);
        enemy.setAttacking(false);
        assertEquals("DungeonEnemy left", enemy.toStringImg());

        enemy.setFacing(Direction.RIGHT);
        enemy.setAttacking(true);
        assertEquals("DungeonEnemy right attack", enemy.toStringImg());

        enemy.setFacing(Direction.DOWN);
        enemy.setAttacking(false);
        assertEquals("DungeonEnemy front", enemy.toStringImg());

        enemy.setFacing(Direction.UP);
        assertEquals("DungeonEnemy back", enemy.toStringImg());

        enemy.setFacing(null);
        assertEquals("DungeonEnemy ", enemy.toStringImg());

        enemy.setAttacking(true);
        assertEquals("DungeonEnemy  attack", enemy.toStringImg());
    }
}