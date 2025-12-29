package controller_test;

import controller.GameController;
import gui.Gui;
import model.game.Game;
import model.game.level.Level;
import model.entities.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class GameControllerTest {
    private Game mockGame;
    private Gui mockGui;
    private GameController gameController;

    @BeforeEach
    void setUp() throws Exception {
        mockGame = mock(Game.class);
        mockGui = mock(Gui.class);

        Level mockLevel = mock(Level.class);
        Player mockPlayer = mock(Player.class);

        when(mockGame.getCurrentLevel()).thenReturn(mockLevel);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);

        when(mockGame.isGameOver()).thenReturn(true);

        gameController = new GameController(mockGame, mockGui);
    }

    @Test
    void testUpdateAndHandleInputDoNothing() throws Exception {

        gameController.handleInput();
        gameController.update();

        verifyNoInteractions(mockGui);
    }
}