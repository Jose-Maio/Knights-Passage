package model_test;

import model.Position;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    private Arena arena;
    private Key key;

    @BeforeEach
    void setUp() {
        List<model.entities.objects.Object> staticObjects = new ArrayList<>();
        staticObjects.add(new Tree(new Position(10, 10)));
        List<model.entities.objects.Object> dynamicObjects = new ArrayList<>();
        key = new Key(new Position(20, 20));
        dynamicObjects.add(key);

        arena = new Arena(staticObjects, dynamicObjects, "bg.png", new Rectangle(0, 0, 400, 208));
    }

    @Test
    void testGetters() {
        assertEquals(1, arena.getStaticObjectList().size());
        assertEquals(1, arena.getDynamicObjectList().size());
        assertEquals(2, arena.getAllObjectList().size());
    }

    @Test
    void testIsBlocked() {
        assertTrue(arena.isBlocked(new Position(10, 10)));
        assertFalse(arena.isBlocked(new Position(20, 20)));
    }

    @Test
    void testKeyManagement() {
        assertNotNull(arena.getKey());
        arena.pickKey();
        assertNull(arena.getKey());
    }

    @Test
    void testIsInsideArena() {
        assertTrue(arena.isInsideArena(new Rectangle(10, 10, 20, 20)));
        assertFalse(arena.isInsideArena(new Rectangle(410, 10, 20, 20)));
    }
}
