package controller_test;

import controller.menu.SettingsMenuController;
import gui.Gui;
import model.game.config.Difficulty;
import model.game.menu.SettingsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SettingsMenuControllerTest {

    private Gui mockGui;
    private SettingsMenu menu;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        menu = new SettingsMenu();
    }

    @Test
    void testUpdateEasy() {
        SettingsMenuController controller = new SettingsMenuController(menu, mockGui);
        Difficulty result = controller.update();
        assertEquals(Difficulty.EASY, result);
    }

    @Test
    void testUpdateMedium() {
        SettingsMenuController controller = new SettingsMenuController(menu, mockGui);
        menu.nextOption();
        Difficulty result = controller.update();
        assertEquals(Difficulty.MEDIUM, result);
    }

    @Test
    void testUpdateHard() {
        SettingsMenuController controller = new SettingsMenuController(menu, mockGui);
        menu.nextOption();
        menu.nextOption();
        Difficulty result = controller.update();
        assertEquals(Difficulty.HARD, result);
    }
}
