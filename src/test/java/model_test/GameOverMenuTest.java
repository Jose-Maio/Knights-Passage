package model_test;

import model.Options;
import model.game.Game;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.LevelFactory;
import model.game.menu.GameOverMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameOverMenuTest {

    @Test
    void testConstructorWithLoss() {
        Game game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
        game.setGameOver();
        GameOverMenu menu = new GameOverMenu(game);
        assertEquals(2, menu.getButtons().size());
        assertTrue(menu.getBackgroundImg().contains("dead"));
    }

    @Test
    void testConstructorWithWin() {
        Game game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
        while (game.getLevels().indexOf(game.getCurrentLevel()) < game.getLevels().size() - 1) {
            game.nextLevel();
        }
        game.nextLevel();
        GameOverMenu menu = new GameOverMenu(game);
        assertTrue(menu.getBackgroundImg().contains("victory"));
    }
}

