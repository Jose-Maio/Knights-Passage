package model_test;

import model.Direction;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {
    private Player player;
    private final int initialHealth = 100;
    private final int attackPower = 20;

    @BeforeEach
    void setUp() {
        player = new Player(initialHealth, attackPower);
    }

    @Test
    void testConstructor() {
        assertEquals(initialHealth, player.getHealth());
        assertEquals(initialHealth, player.getMaxHealth());
        assertEquals(attackPower, player.getAttackPower());
        assertEquals(Direction.RIGHT, player.getFacing());
        assertFalse(player.hasKey());
        assertFalse(player.isAttacking());
        assertEquals(new Position(0, 144), player.getPosition());
    }

    @Test
    void testSetPositionUpdatesRectangles() {
        Position newPos = new Position(50, 50);
        player.setPosition(newPos);

        assertEquals(newPos, player.getPosition());
        assertEquals(52, player.getHitbox().x);
        assertEquals(52, player.getHitbox().y);
        assertEquals(47, player.getAttackRange().x);
    }

    @Test
    void testMove() {
        player.move(Direction.RIGHT);
        assertEquals(new Position(1, 144), player.getPosition());
        assertEquals(Direction.RIGHT, player.getFacing());
    }

    @Test
    void testHealthAndDamage() {
        assertFalse(player.isDead());
        player.takeDamage(30);
        assertEquals(70, player.getHealth());

        player.takeDamage(70);
        assertTrue(player.isDead());
    }

    @Test
    void testKeyLogic() {
        assertFalse(player.hasKey());
        player.pickUpKey();
        assertTrue(player.hasKey());
        player.setHasKey(false);
        assertFalse(player.hasKey());
    }

    @Test
    void testAttackCooldown() throws InterruptedException {
        player.attackDelay = 50;
        assertTrue(player.canAttack());

        Character target = mock(Character.class);
        player.attack(target);

        verify(target).takeDamage(attackPower);
        assertFalse(player.canAttack());

        Thread.sleep(60);
        assertTrue(player.canAttack());
    }

    @Test
    void testSetAttacking() {
        player.setAttacking(true);
        assertTrue(player.isAttacking());
    }

    @Test
    void testToStringImg() {
        player.setAttacking(false);

        player.setFacing(Direction.LEFT);
        assertEquals("Knight left", player.toStringImg());

        player.setFacing(Direction.RIGHT);
        assertEquals("Knight right", player.toStringImg());

        player.setFacing(Direction.UP);
        assertEquals("Knight back", player.toStringImg());

        player.setFacing(Direction.DOWN);
        assertEquals("Knight front", player.toStringImg());

        player.setAttacking(true);
        player.setFacing(Direction.LEFT);
        assertEquals("Knight left attack", player.toStringImg());

        player.setFacing(null);
        assertEquals("Knight front attack", player.toStringImg());
    }
}