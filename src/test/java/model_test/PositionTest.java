package model_test;

import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testConstructor() {
        Position pos = new Position(10, 20);
        assertEquals(10, pos.getX());
        assertEquals(20, pos.getY());
    }

    @Test
    void testSetters() {
        Position pos = new Position(5, 5);
        pos.setX(15);
        pos.setY(25);
        assertEquals(15, pos.getX());
        assertEquals(25, pos.getY());
    }

    @Test
    void testEquals() {
        Position pos1 = new Position(10, 20);
        Position pos2 = new Position(10, 20);
        Position pos3 = new Position(10, 21);

        assertEquals(pos1, pos2);
        assertNotEquals(pos1, pos3);
        assertNotEquals(pos1, null);
    }
}
