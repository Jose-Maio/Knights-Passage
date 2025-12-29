package controller_test;

import controller.menu.ControlsMenuController;
import gui.Gui;
import model.Button;
import model.game.menu.ControlsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControlsMenuControllerTest {
    private ControlsMenu mockMenu;
    private Gui mockGui;
    private Button mockButton;
    private ControlsMenuController controller;

    @BeforeEach
    void setUp() {
        mockMenu = mock(ControlsMenu.class);
        mockGui = mock(Gui.class);
        mockButton = mock(Button.class);
    }

    @Test
    void testConstructor() throws Exception {

        controller = new ControlsMenuController(mockMenu, mockGui);
        assertNotNull(controller);

        when(mockMenu.getSelectedButton()).thenReturn(mockButton);
        when(mockButton.getOption()).thenReturn(null);

        controller.update();

        verify(mockMenu).getSelectedButton();
        verify(mockButton).getOption();
    }
}