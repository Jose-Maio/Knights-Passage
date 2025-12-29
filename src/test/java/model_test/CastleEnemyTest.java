package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.CastleEnemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastleEnemyTest {

    @Test
    void testConstructor() {
        Position pos = new Position(50, 50);
        CastleEnemy enemy = new CastleEnemy(pos, 100, 10);

        assertEquals(pos, enemy.getPosition());
        assertEquals(100, enemy.getHealth());
        assertEquals(10, enemy.getDamage());
    }

    @Test
    void testToStringImg() {
        CastleEnemy enemy = new CastleEnemy(new Position(0, 0), 100, 10);

        enemy.setFacing(Direction.LEFT);
        enemy.setAttacking(false);
        assertEquals("CastleEnemy left", enemy.toStringImg());

        enemy.setFacing(Direction.RIGHT);
        enemy.setAttacking(true);
        assertEquals("CastleEnemy right attack", enemy.toStringImg());

        enemy.setFacing(Direction.DOWN);
        enemy.setAttacking(false);
        assertEquals("CastleEnemy front", enemy.toStringImg());

        enemy.setFacing(Direction.UP);
        assertEquals("CastleEnemy back", enemy.toStringImg());

        enemy.setFacing(null);
        assertEquals("CastleEnemy ", enemy.toStringImg());

        enemy.setAttacking(true);
        assertEquals("CastleEnemy  attack", enemy.toStringImg());
    }
}