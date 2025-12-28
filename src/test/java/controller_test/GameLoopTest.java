package controller_test;

import controller.GameLoop;
import controller.LevelController;
import controller.managers.InputManager;
import gui.Gui;
import model.game.Game;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.GameView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameLoopTest {

    private Game mockGame;
    private Gui mockGui;
    private GameView mockGameView;
    private LevelController mockLevelController;
    private InputManager mockInputManager;
    private Level mockLevel;

    @BeforeEach
    void setUp() throws IOException {
        mockGame = mock(Game.class);
        mockGui = mock(Gui.class);
        mockGameView = mock(GameView.class);
        mockLevelController = mock(LevelController.class);
        mockInputManager = mock(InputManager.class);
        mockLevel = mock(Level.class);

        when(mockGame.getCurrentLevel()).thenReturn(mockLevel);
        when(mockInputManager.getPressedDirections()).thenReturn(new java.util.HashSet<>());
        when(mockInputManager.isAttackPressed()).thenReturn(false);
        doNothing().when(mockGameView).render(any());
        doNothing().when(mockLevelController).update(any(), any(), anyBoolean());
    }

    @Test
    void testRunWithGameOver() throws Exception {
        when(mockGame.isGameOver()).thenReturn(true);
        GameLoop gameLoop = new GameLoop(mockGame, mockGui, mockGameView, mockLevelController, mockInputManager);
        gameLoop.run();
        verify(mockGame, atLeastOnce()).isGameOver();
    }

    @Test
    void testRunWithExitPressed() throws Exception {
        when(mockGame.isGameOver()).thenReturn(false, true);
        when(mockInputManager.isExitPressed()).thenReturn(true);
        com.googlecode.lanterna.screen.Screen mockScreen = mock(com.googlecode.lanterna.screen.Screen.class);
        when(mockGui.getScreen()).thenReturn(mockScreen);

        GameLoop gameLoop = new GameLoop(mockGame, mockGui, mockGameView, mockLevelController, mockInputManager);
        gameLoop.run();
        verify(mockScreen).close();
    }
}
