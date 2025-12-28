package model;

import model.entities.characters.Player;
import model.game.Game;
import model.game.level.Level;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game g;

    @BeforeEach
    void setup() {
        g = new Game(new GameConfiguration(Difficulty.MEDIUM));
    }

    @Test
    void testNextLevel() {
        g.nextLevel();
        // g.update();
        assertTrue(g.isGameOver());
    }

    @Test
    void testGameOverIfPlayerDies() {
        Level lvl = g.getCurrentLevel();
        Player p = lvl.getPlayer();
        p.takeDamage(p.getHealth());
        // g.update(Direction.RIGHT);
        assertTrue(g.isGameOver());
    }

    @Test
    void testSetGameOver() {
        g.setGameOver();
        assertTrue(g.isGameOver());
    }

    @Test
    void testGetLevels() {
        List<Level> levels = new ArrayList<>();
        levels.add(g.getCurrentLevel());
        assertEquals(g.getLevels(), levels);
    }

    @Test
    void testIsGameOverIsFalseInitially() {
        assertFalse(g.isGameOver());
    }

}