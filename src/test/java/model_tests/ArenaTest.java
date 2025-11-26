package model_tests;

import model.game.Arena;
import model.Position;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {

    @Test
    void testIsBlockedTrue() {
        Object tree = new Tree(new Position(5, 5));
        Arena arena = new Arena(List.of(tree), "bg");

        assertTrue(arena.isBlocked(new Position(5,5)));
    }

    @Test
    void testIsBlockedFalse() {
        Object tree = new Tree(new Position(5, 5));
        Arena arena = new Arena(List.of(tree), "bg");

        assertFalse(arena.isBlocked(new Position(1,1)));
    }
}
