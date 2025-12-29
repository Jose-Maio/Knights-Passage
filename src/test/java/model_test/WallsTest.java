package model_test;

import model.Position;
import model.entities.objects.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallsTest {

    @Test
    void testBigWallH() {
        BigWallH wall = new BigWallH(new Position(10, 10));
        assertTrue(wall.isSolid());
        assertEquals("BigWallH", wall.toStringImg());
        assertEquals(51, wall.getHitbox().width);
        assertEquals(8, wall.getHitbox().height);
    }

    @Test
    void testBigWallV() {
        BigWallV wall = new BigWallV(new Position(10, 10));
        assertTrue(wall.isSolid());
        assertEquals("BigWallV", wall.toStringImg());
        assertEquals(8, wall.getHitbox().width);
        assertEquals(51, wall.getHitbox().height);
    }

    @Test
    void testSmallWallH() {
        SmallWallH wall = new SmallWallH(new Position(10, 10));
        assertTrue(wall.isSolid());
        assertEquals("SmallWallH", wall.toStringImg());
        assertEquals(15, wall.getHitbox().width);
        assertEquals(8, wall.getHitbox().height);
    }

    @Test
    void testSmallWallV() {
        SmallWallV wall = new SmallWallV(new Position(10, 10));
        assertTrue(wall.isSolid());
        assertEquals("SmallWallV", wall.toStringImg());
        assertEquals(8, wall.getHitbox().width);
        assertEquals(15, wall.getHitbox().height);
    }
}
