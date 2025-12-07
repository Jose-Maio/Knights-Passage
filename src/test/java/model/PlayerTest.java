package model;


import model.entities.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(20, 5);
        player.setPosition(new Position(10, 10));
    }

    @Test
    void testInitialValues() {
        assertEquals(20, player.getHealth());
        assertEquals(5, player.getAttackPower());
        assertEquals(Direction.RIGHT, player.getFacing());
        assertFalse(player.hasKey());
        assertFalse(player.isDead());
    }

    @Test
    void testSetPosition() {
        player.setPosition(new Position(3, 4));
        assertEquals(3, player.getPosition().getX());
        assertEquals(4, player.getPosition().getY());
    }

    @Test
    void testMoveUp() {
        player.move(Direction.UP);
        assertEquals(10, player.getPosition().getX());
        assertEquals(9,  player.getPosition().getY());
        assertEquals(Direction.UP, player.getFacing());
    }

    @Test
    void testMoveDown() {
        player.move(Direction.DOWN);
        assertEquals(10, player.getPosition().getX());
        assertEquals(11, player.getPosition().getY());
        assertEquals(Direction.DOWN, player.getFacing());
    }

    @Test
    void testMoveLeft() {
        player.move(Direction.LEFT);
        assertEquals(9, player.getPosition().getX());
        assertEquals(10, player.getPosition().getY());
        assertEquals(Direction.LEFT, player.getFacing());
    }

    @Test
    void testMoveRight() {
        player.move(Direction.RIGHT);
        assertEquals(11, player.getPosition().getX());
        assertEquals(10, player.getPosition().getY());
        assertEquals(Direction.RIGHT, player.getFacing());
    }

    @Test
    void testTakeDamage() {
        player.takeDamage(7);
        assertEquals(13, player.getHealth());
        assertFalse(player.isDead());

        player.takeDamage(20);
        assertTrue(player.isDead());
    }

    @Test
    void testPickUpKey() {
        assertFalse(player.hasKey());
        player.pickUpKey();
        assertTrue(player.hasKey());
    }

    @Test
    void testAttackDoesNotThrow() {
        assertDoesNotThrow(() -> player.attack());
    }
}
