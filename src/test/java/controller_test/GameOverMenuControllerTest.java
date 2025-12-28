package controller_test;

import controller.menu.GameOverMenuController;
import gui.Gui;
import model.game.Game;
import model.game.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameOverMenuControllerTest {

    private Gui mockGui;
    private GameOverMenu menu;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        Game mockGame = mock(Game.class);
        when(mockGame.isWin()).thenReturn(false);
        menu = new GameOverMenu(mockGame);
        if (menu.getButtons().size() > 0) {
            menu.updateCurrentButton(true);
        }
    }

    @Test
    void testUpdateWithExit() throws Exception {
        GameOverMenuController controller = new GameOverMenuController(menu, mockGui);
        menu.nextOption();
        com.googlecode.lanterna.screen.Screen mockScreen = mock(com.googlecode.lanterna.screen.Screen.class);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        menu.setSelected(true);

        assertNull(controller.update());
        verify(mockScreen).close();
    }
}
