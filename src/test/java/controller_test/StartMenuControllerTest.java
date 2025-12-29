package controller_test;

import com.googlecode.lanterna.screen.Screen;
import controller.menu.StartMenuController;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.StartMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class StartMenuControllerTest {
    private StartMenu mockMenu;
    private Gui mockGui;
    private Button mockButton;
    private StartMenuController controller;

    @BeforeEach
    void setUp() {
        mockMenu = mock(StartMenu.class);
        mockGui = mock(Gui.class);
        mockButton = mock(Button.class);

        when(mockMenu.getSelectedButton()).thenReturn(mockButton);
        controller = new StartMenuController(mockMenu, mockGui);
    }

    @Test
    void testUpdateExit() throws Exception {
        when(mockButton.getOption()).thenReturn(Options.EXIT);
        Screen mockScreen = mock(Screen.class);
        when(mockGui.getScreen()).thenReturn(mockScreen);

        controller.update();

        verify(mockScreen).close();
    }


}