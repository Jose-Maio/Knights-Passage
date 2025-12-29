package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(100, 10);
    }

    @Test
    void testConstructor() {
        assertEquals(100, player.getMaxHealth());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getAttackPower());
        assertFalse(player.hasKey());
    }

    @Test
    void testMovement() {
        player.move(Direction.UP);
        assertEquals(0, player.getPosition().getX());
        assertEquals(143, player.getPosition().getY());
        assertEquals(Direction.UP, player.getFacing());
    }

    @Test
    void testHealth() {
        player.takeDamage(30);
        assertEquals(70, player.getHealth());
        assertFalse(player.isDead());

        player.takeDamage(80);
        assertTrue(player.isDead());
    }

    @Test
    void testKeyManagement() {
        assertFalse(player.hasKey());
        player.pickUpKey();
        assertTrue(player.hasKey());
        player.setHasKey(false);
        assertFalse(player.hasKey());
    }

    @Test
    void testAttack() {
        ForestEnemy enemy = new ForestEnemy(new Position(10, 10), 50, 5);
        player.attack(enemy);
        assertEquals(40, enemy.getHealth());
    }

    @Test
    void testCanAttack() {
        assertTrue(player.canAttack());
        player.attack(new ForestEnemy(new Position(10, 10), 50, 5));
        assertFalse(player.canAttack());
    }

    @Test
    void testToStringImg() {
        player.setFacing(Direction.RIGHT);
        assertTrue(player.toStringImg().contains("right"));

        player.setAttacking(true);
        assertTrue(player.toStringImg().contains("attack"));
    }
}
