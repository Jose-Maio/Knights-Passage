package model_test;

import model.Options;
import model.game.menu.SettingsMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsMenuTest {

    @Test
    void testConstructor() {
        SettingsMenu menu = new SettingsMenu();
        assertEquals(3, menu.getButtons().size());
        assertEquals(Options.EASY_MODE, menu.getSelectedButton().getOption());
    }

    @Test
    void testNavigation() {
        SettingsMenu menu = new SettingsMenu();
        menu.nextOption();
        assertEquals(Options.MEDIUM_MODE, menu.getSelectedButton().getOption());
    }
}

