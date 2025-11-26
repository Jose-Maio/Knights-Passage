package model_tests;

import model.entities.characters.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerHealthTest {

    @Test
    void testTakeDamage() {
        Player p = new Player(20, 5);
        p.takeDamage(5);
        assertEquals(15, p.getHealth());
    }

    @Test
    void testDeath() {
        Player p = new Player(10, 5);
        p.takeDamage(10);
        assertTrue(p.isDead());
    }

    @Test
    void testNotDead() {
        Player p = new Player(10, 5);
        p.takeDamage(9);
        assertFalse(p.isDead());
    }
}
