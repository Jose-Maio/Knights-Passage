package model_tests;

import model.Direction;
import model.Position;
import model.entities.characters.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerMovementTest {

    @Test
    void testMoveUp() {
        Player p = new Player(10, 5);
        p.setPosition(new Position(10,10));
        p.move(Direction.UP);
        assertEquals(new Position(10,9), p.getPosition());
    }

    @Test
    void testMoveDown() {
        Player p = new Player(10, 5);
        p.setPosition(new Position(10,10));
        p.move(Direction.DOWN);
        assertEquals(new Position(10,11), p.getPosition());
    }

    @Test
    void testMoveLeft() {
        Player p = new Player(10, 5);
        p.setPosition(new Position(10,10));
        p.move(Direction.LEFT);
        assertEquals(new Position(9,10), p.getPosition());
    }

    @Test
    void testMoveRight() {
        Player p = new Player(10, 5);
        p.setPosition(new Position(10,10));
        p.move(Direction.RIGHT);
        assertEquals(new Position(11,10), p.getPosition());
    }
}
