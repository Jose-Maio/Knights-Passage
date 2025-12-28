package model_test;

import model.Position;
import model.entities.objects.BloodDrops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloodDropsTest {

    @Test
    void testConstructor() {
        BloodDrops blood = new BloodDrops(new Position(10, 10));
        assertEquals(10, blood.getPosition().getX());
        assertFalse(blood.isSolid());
    }

    @Test
    void testToStringImg() {
        BloodDrops blood = new BloodDrops(new Position(10, 10));
        assertEquals("blood_splatter", blood.toStringImg());
    }
}

