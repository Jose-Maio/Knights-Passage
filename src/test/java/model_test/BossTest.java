package model_test;

import model.Direction;
import model.Position;
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
    void testConstructor() {
        assertEquals(50, boss.getMaxHealth());
        assertEquals(8, boss.getDamage());
        assertEquals(39, boss.getHitbox().width);
        assertEquals(35, boss.getHitbox().height);
    }

    @Test
    void testMovement() {
        boss.move(Direction.RIGHT);
        assertEquals(11, boss.getPosition().getX());
        assertEquals(10, boss.getPosition().getY());
    }

    @Test
    void testHealth() {
        boss.takeDamage(30);
        assertEquals(20, boss.getHealth());
        assertFalse(boss.isDead());
    }

    @Test
    void testToStringImg() {
        boss.setFacing(Direction.RIGHT);
        assertTrue(boss.toStringImg().contains("Boss"));
        boss.setAttacking(true);
        assertTrue(boss.toStringImg().contains("attack"));
    }
}
