package view_test;

import gui.Gui;
import model.game.Game;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.LevelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.GameView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameViewTest {

    private Gui mockGui;
    private GameView gameView;
    private Game game;

    @BeforeEach
    void setUp() throws Exception {
        mockGui = mock(Gui.class);
        game = new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM)));
        when(mockGui.getWidth()).thenReturn(200);
        when(mockGui.getHeight()).thenReturn(200);
        gameView = new GameView(mockGui);
    }

    @Test
    void testGetGui() {
        assertEquals(mockGui, gameView.getGui());
    }

    @Test
    void testRender() throws Exception {
        assertDoesNotThrow(() -> gameView.render(game));
        verify(mockGui, atLeastOnce()).refresh();
    }
}
