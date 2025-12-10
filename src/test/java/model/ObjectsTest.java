package model;

import model.entities.objects.BigWallH;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectsTest {

    private Tree tree;
    private BigWallH bigWallH;
    private Key key;

    @BeforeEach
    void setUp() {
        tree = new Tree(new Position(10, 10));
        bigWallH = new BigWallH(new Position(30, 30));
        key = new Key(new Position(50, 50));
    }

    @Test
    void testInitialValues() {
        // Tree
        assertEquals(10, tree.getPosition().getX());
        assertEquals(10, tree.getPosition().getY());

        // BigWallH
        assertEquals(30, bigWallH.getPosition().getX());
        assertEquals(30, bigWallH.getPosition().getY());

        // Key
        assertEquals(50, key.getPosition().getX());
        assertEquals(50, key.getPosition().getY());
    }

    @Test
    void testIsSolid() {
        assertTrue(tree.isSolid());
        assertTrue(bigWallH.isSolid());
        assertFalse(key.isSolid());
    }
}
