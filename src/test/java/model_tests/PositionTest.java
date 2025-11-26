package model_tests;

import model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void testEqualsSameCoordinates() {
        Position p1 = new Position(10, 20);
        Position p2 = new Position(10, 20);
        assertEquals(p1, p2);
    }

    @Test
    void testNotEqualsDifferentCoordinates() {
        Position p1 = new Position(10, 20);
        Position p2 = new Position(11, 20);
        assertNotEquals(p1, p2);
    }

    @Test
    void testSetters() {
        Position p = new Position(0, 0);
        p.setX(5);
        p.setY(7);
        assertEquals(5, p.getX());
        assertEquals(7, p.getY());
    }
}
