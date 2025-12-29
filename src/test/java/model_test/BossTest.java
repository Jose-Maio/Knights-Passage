package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.enemies.Boss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void testConstructor() {
        Position pos = new Position(100, 200);
        Boss boss = new Boss(pos, 500, 50);

        assertEquals(pos, boss.getPosition());
        assertEquals(500, boss.getHealth());
        assertEquals(50, boss.getDamage());
    }

    @Test
    void testToStringImg() {
        Boss boss = new Boss(new Position(0, 0), 100, 10);

        boss.setFacing(Direction.RIGHT);
        boss.setAttacking(false);
        assertEquals("Boss right", boss.toStringImg());

        boss.setAttacking(true);
        assertEquals("Boss right attack end", boss.toStringImg());

        boss.setFacing(Direction.LEFT);
        boss.setAttacking(false);
        assertEquals("Boss left", boss.toStringImg());

        boss.setFacing(Direction.DOWN);
        assertEquals("Boss left", boss.toStringImg());

        boss.setFacing(Direction.UP);
        assertEquals("Boss left", boss.toStringImg());

        boss.setFacing(null);
        assertEquals("Boss ", boss.toStringImg());

        boss.setAttacking(true);
        assertEquals("Boss  attack end", boss.toStringImg());
    }
}