package model_test;

import model.Position;
import model.entities.objects.Key;
import model.entities.objects.Object;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArenaTest {
    private Arena arena;
    private List<Object> staticObjects;
    private List<Object> dynamicObjects;
    private Rectangle dimensions;
    private String bg = "test_bg.png";

    @BeforeEach
    void setUp() {
        staticObjects = new ArrayList<>();
        dynamicObjects = new ArrayList<>();
        dimensions = new Rectangle(0, 0, 100, 100);
        arena = new Arena(staticObjects, dynamicObjects, bg, dimensions);
    }

    @Test
    void testGetters() {
        assertEquals(bg, arena.getBackgroundImg());
        assertEquals(0, arena.getStaticObjectList().size());
        assertEquals(0, arena.getDynamicObjectList().size());
    }

    @Test
    void testGetAllObjectList() {
        Object s1 = mock(Object.class);
        Object d1 = mock(Object.class);

        staticObjects.add(s1);
        dynamicObjects.add(d1);

        arena = new Arena(staticObjects, dynamicObjects, bg, dimensions);

        List<Object> all = arena.getAllObjectList();
        assertEquals(2, all.size());
        assertTrue(all.contains(s1));
        assertTrue(all.contains(d1));
    }

    @Test
    void testIsBlocked() {
        Position pos = new Position(10, 10);
        Object solidObj = mock(Object.class);
        when(solidObj.getPosition()).thenReturn(pos);
        when(solidObj.isSolid()).thenReturn(true);

        Object nonSolidObj = mock(Object.class);
        when(nonSolidObj.getPosition()).thenReturn(new Position(20, 20));
        when(nonSolidObj.isSolid()).thenReturn(false);

        staticObjects.add(solidObj);
        dynamicObjects.add(nonSolidObj);
        arena = new Arena(staticObjects, dynamicObjects, bg, dimensions);

        assertTrue(arena.isBlocked(new Position(10, 10)));
        assertFalse(arena.isBlocked(new Position(20, 20)));
        assertFalse(arena.isBlocked(new Position(30, 30)));
    }

    @Test
    void testIsInsideArena() {
        assertTrue(arena.isInsideArena(new Rectangle(10, 10, 5, 5)));

        assertTrue(arena.isInsideArena(new Rectangle(0, 0, 100, 100)));

        assertFalse(arena.isInsideArena(new Rectangle(-1, 10, 5, 5)));

        assertFalse(arena.isInsideArena(new Rectangle(10, -1, 5, 5)));

        assertFalse(arena.isInsideArena(new Rectangle(96, 10, 5, 5)));

        assertFalse(arena.isInsideArena(new Rectangle(10, 96, 5, 5)));
    }

    @Test
    void testKeyManagement() {
        Key key = mock(Key.class);

        assertNull(arena.getKey());

        arena.placeKey(key);
        assertEquals(key, arena.getKey());

        arena.pickKey();
        verify(key, times(1)).pick();
        assertNull(arena.getKey());
        assertFalse(arena.getDynamicObjectList().contains(key));
    }

    @Test
    void testPickKeyWhenNoKeyExists() {
        assertDoesNotThrow(() -> arena.pickKey());
    }
}