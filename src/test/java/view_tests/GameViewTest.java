package view_tests;

import gui.Gui;
import model.game.Game;
import model.game.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.GameView;
import view.LevelRenderer;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameViewTest {

    private Gui mockGui;
    private GameView gameView;
    private Game mockGame;
    private Level mockLevel;
    private LevelRenderer mockLevelRenderer;

    @BeforeEach
    void setUp() {

        mockGui = mock(Gui.class);
        mockGame = mock(Game.class);
        mockLevel = mock(Level.class);
        mockLevelRenderer = mock(LevelRenderer.class);

        when(mockGame.getCurrentLevel()).thenReturn(mockLevel);

        gameView = new GameView(mockGui, mockLevelRenderer);
    }

    @Test
    void testRenderCallsGuiAndLevelRenderer() throws IOException {
        // Call render
        gameView.render(mockGame);

        // Verify gui.clear() is called
        verify(mockGui, times(1)).clear();

        // Verify LevelRenderer.render() is called with correct parameters
        verify(mockLevelRenderer, times(1)).render(mockLevel, mockGui);

        // Verify gui.refresh() is called
        verify(mockGui, times(1)).refresh();
    }
}
