package model_test;

import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position pos;

    @BeforeEach
    void setUp() {
        pos = new Position(10, 20);
    }
    @Test
    void testConstructor() {
        assertEquals(10, pos.getX());
        assertEquals(20, pos.getY());
    }

    @Test
    void testSetters() {
        pos.setX(15);
        pos.setY(25);
        assertEquals(15, pos.getX());
        assertEquals(25, pos.getY());
    }

    @Test
    void testEqualsDifferentObjectSameValues() {
        Position other = new Position(10, 20);
        assertTrue(pos.equals(other));
    }

    @Test
    void testEqualsNull() {
        // Covers: if (o == null) return false;
        assertFalse(pos.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        // Covers: if (getClass() != o.getClass()) return false;
        assertFalse(pos.equals("Not a position object"));
    }

    @Test
    void testEqualsDifferentValues() {
        assertFalse(pos.equals(new Position(10, 21))); // Different Y
        assertFalse(pos.equals(new Position(11, 20))); // Different X
    }
}
