package model_test;

import model.Position;
import model.entities.objects.Key;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {

    @Test
    void testConstructor() {
        Key key = new Key(new Position(10, 10));
        assertEquals(10, key.getPosition().getX());
        assertFalse(key.isSolid());
    }

    @Test
    void testPick() {
        Key key = new Key(new Position(10, 10));
        key.pick();
        assertTrue(true);
    }

    @Test
    void testToStringImg() {
        Key key = new Key(new Position(10, 10));
        assertEquals("Key", key.toStringImg());
    }
}

