package controller_test;

import com.googlecode.lanterna.screen.Screen;
import controller.GameLoop;
import controller.LevelController;
import gui.Gui;
import controller.managers.InputManager;
import model.game.Game;
import model.game.level.Level;
import model.entities.characters.Player;
import view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.mockito.Mockito.*;

class GameLoopTest {
    private Game mockGame;
    private Gui mockGui;
    private GameView mockGameView;
    private LevelController mockLevelController;
    private InputManager mockInputManager;
    private Level mockLevel;
    private Player mockPlayer;
    private GameLoop gameLoop;

    @BeforeEach
    void setUp() {
        mockGame = mock(Game.class);
        mockGui = mock(Gui.class);
        mockGameView = mock(GameView.class);
        mockLevelController = mock(LevelController.class);
        mockInputManager = mock(InputManager.class);
        mockLevel = mock(Level.class);
        mockPlayer = mock(Player.class);

        when(mockGame.getCurrentLevel()).thenReturn(mockLevel);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);

        gameLoop = new GameLoop(mockGame, mockGui, mockGameView, mockLevelController, mockInputManager);
    }

    @Test
    void testRunExitPressed() throws Exception {
        when(mockGame.isGameOver()).thenReturn(false);
        when(mockInputManager.isExitPressed()).thenReturn(true);

        Screen mockScreen = mock(Screen.class);
        when(mockGui.getScreen()).thenReturn(mockScreen);

        gameLoop.run();

        verify(mockScreen).close();

        verify(mockGameView, never()).render(any());
    }

    @Test
    void testRunOneCycleAndGameOver() throws Exception {

        when(mockGame.isGameOver()).thenReturn(false, true);
        when(mockInputManager.isExitPressed()).thenReturn(false);

        HashSet directions = new HashSet<>();
        when(mockInputManager.getPressedDirections()).thenReturn(directions);
        when(mockInputManager.isAttackPressed()).thenReturn(false);

        when(mockPlayer.isDead()).thenReturn(false);
        when(mockLevel.isComplete()).thenReturn(false);

        gameLoop.run();

        verify(mockGameView).render(mockGame);
        verify(mockLevelController).update(eq(mockLevel), eq(directions), eq(false));
    }

    @Test
    void testUpdateGameStatusPlayerDead() throws Exception {
        when(mockGame.isGameOver()).thenReturn(false, true);
        when(mockInputManager.isExitPressed()).thenReturn(false);

        when(mockPlayer.isDead()).thenReturn(true);

        gameLoop.run();

        verify(mockGame).setGameOver();
    }

    @Test
    void testUpdateGameStatusLevelComplete() throws Exception {
        when(mockGame.isGameOver()).thenReturn(false, true);
        when(mockInputManager.isExitPressed()).thenReturn(false);

        when(mockPlayer.isDead()).thenReturn(false);
        when(mockLevel.isComplete()).thenReturn(true);

        gameLoop.run();

        verify(mockGame).nextLevel();
        verify(mockLevelController).setHasSpawnedPlayer(false);
    }
}