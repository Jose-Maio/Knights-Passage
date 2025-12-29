package controller_test;

import controller.menu.StartMenuController;
import gui.Gui;
import model.game.menu.StartMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StartMenuControllerTest {

    private Gui mockGui;
    private StartMenu menu;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        menu = new StartMenu();
    }

    @Test
    void testUpdateWithExit() throws Exception {
        StartMenuController controller = new StartMenuController(menu, mockGui);
        for (int i = 0; i < 3; i++) {
            menu.nextOption();
        }
        com.googlecode.lanterna.screen.Screen mockScreen = mock(com.googlecode.lanterna.screen.Screen.class);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        when(mockGui.step()).thenReturn(null);
        menu.setSelected(true);

        assertNull(controller.update());
        verify(mockScreen).close();
    }

    @Test
    void testHandleInput() throws Exception {
        StartMenuController controller = new StartMenuController(menu, mockGui);
        when(mockGui.step()).thenReturn(null);
        assertDoesNotThrow(() -> controller.handleInput());
    }
}
