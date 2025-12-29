package model_test;

import model.entities.characters.Player;
import model.game.Game;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.LevelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
    }

    @Test
    void testConstructor() {
        assertNotNull(game.getCurrentLevel());
        assertFalse(game.isGameOver());
        assertFalse(game.isWin());
    }

    @Test
    void testNextLevel() {
        int initialLevel = game.getLevels().indexOf(game.getCurrentLevel());
        game.nextLevel();
        assertNotEquals(initialLevel, game.getLevels().indexOf(game.getCurrentLevel()));
    }

    @Test
    void testSetGameOver() {
        game.setGameOver();
        assertTrue(game.isGameOver());
    }

    @Test
    void testWinCondition() {
        while (game.getLevels().indexOf(game.getCurrentLevel()) < game.getLevels().size() - 1) {
            game.nextLevel();
        }
        game.nextLevel();
        assertTrue(game.isGameOver());
        assertTrue(game.isWin());
    }
}
