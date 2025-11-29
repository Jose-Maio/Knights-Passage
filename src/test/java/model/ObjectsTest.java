package model;

import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectsTest {

    private Tree tree;
    private Wall wall;
    private Key key;

    @BeforeEach
    void setUp() {
        tree = new Tree(new Position(10, 10));
        wall = new Wall(new Position(30, 30));
        key = new Key(new Position(50, 50));
    }

    @Test
    void testInitialValues() {
        // Tree
        assertEquals(10, tree.getPosition().getX());
        assertEquals(10, tree.getPosition().getY());

        // Wall
        assertEquals(30, wall.getPosition().getX());
        assertEquals(30, wall.getPosition().getY());

        // Key
        assertEquals(50, key.getPosition().getX());
        assertEquals(50, key.getPosition().getY());
    }

    @Test
    void testIsSolid() {
        assertTrue(tree.isSolid());
        assertTrue(wall.isSolid());
        assertFalse(key.isSolid());
    }
}
