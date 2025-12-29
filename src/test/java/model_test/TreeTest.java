package model_test;

import model.Position;
import model.entities.objects.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void testConstructor() {
        Tree tree = new Tree(new Position(10, 10));
        assertEquals(10, tree.getPosition().getX());
        assertEquals(10, tree.getPosition().getY());
    }

    @Test
    void testIsSolid() {
        Tree tree = new Tree(new Position(10, 10));
        assertTrue(tree.isSolid());
    }

    @Test
    void testToStringImg() {
        Tree tree = new Tree(new Position(10, 10));
        assertEquals("Tree", tree.toStringImg());
    }
}

