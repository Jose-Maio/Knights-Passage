package model_test;

import model.Options;
import model.game.menu.ControlsMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlsMenuTest {

    @Test
    void testConstructor() {
        ControlsMenu menu = new ControlsMenu();
        assertEquals(1, menu.getButtons().size());
        assertEquals(Options.BACK, menu.getSelectedButton().getOption());
        assertTrue(menu.getBackgroundImg().contains("bg.png"));
    }
}

