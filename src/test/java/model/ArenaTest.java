package model;

import model.entities.objects.Object;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArenaTest {

    private Object solidObj;
    private Object nonSolidObj;
    private Arena arena;

    @BeforeEach
    void setUp() {
        solidObj = mock(Object.class);
        nonSolidObj = mock(Object.class);

        when(solidObj.getPosition()).thenReturn(new Position(3, 3));
        when(solidObj.isSolid()).thenReturn(true);

        when(nonSolidObj.getPosition()).thenReturn(new Position(5, 5));
        when(nonSolidObj.isSolid()).thenReturn(false);

        List<Object> objects = Arrays.asList(solidObj, nonSolidObj);
        arena = new Arena(objects, "castle.png");
    }

    @Test
    void testGetObjectList() {
        assertEquals(2, arena.getObjectList().size());
        assertTrue(arena.getObjectList().contains(solidObj));
        assertTrue(arena.getObjectList().contains(nonSolidObj));
    }

    @Test
    void testGetBackgroundImage() {
        assertEquals("castle.png", arena.getBackgroundImg());
    }

    @Test
    void testIsBlocked() {
        assertTrue(arena.isBlocked(new Position(3, 3)));
        assertFalse(arena.isBlocked(new Position(5, 5)));
        assertFalse(arena.isBlocked(new Position(5, 5)));
        assertFalse(arena.isBlocked(new Position(5, 5)));
    }
}

