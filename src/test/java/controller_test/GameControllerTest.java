package controller_test;

import controller.GameController;
import gui.Gui;
import model.game.Game;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.LevelFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameControllerTest {

    @Test
    void testConstructor() throws Exception {
        Game game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
        Gui gui = mock(Gui.class);
        GameController controller = new GameController(game, gui);
        assertNotNull(controller);
    }

    @Test
    void testHandleInput() {
        try {
            Game game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
            Gui gui = mock(Gui.class);
            GameController controller = new GameController(game, gui);
            controller.handleInput();
            assertTrue(true);
        } catch (Exception e) {
            fail("Should not throw exception");
        }
    }

    @Test
    void testUpdate() throws Exception {
        Game game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
        Gui gui = mock(Gui.class);
        GameController controller = new GameController(game, gui);
        assertNull(controller.update());
    }
}
