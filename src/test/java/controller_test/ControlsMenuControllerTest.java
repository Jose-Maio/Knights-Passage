package controller_test;

import controller.menu.ControlsMenuController;
import gui.Gui;
import model.game.menu.ControlsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControlsMenuControllerTest {

    private Gui mockGui;
    private ControlsMenu menu;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        menu = new ControlsMenu();
    }

    @Test
    void testUpdate() throws Exception {
        ControlsMenuController controller = new ControlsMenuController(menu, mockGui);
        assertNull(controller.update());
    }
}
