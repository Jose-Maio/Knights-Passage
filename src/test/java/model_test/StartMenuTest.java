package model_test;

import model.Options;
import model.game.menu.StartMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartMenuTest {

    @Test
    void testConstructor() {
        StartMenu menu = new StartMenu();
        assertEquals(4, menu.getButtons().size());
        assertEquals(Options.START, menu.getSelectedButton().getOption());
    }

    @Test
    void testNavigation() {
        StartMenu menu = new StartMenu();
        menu.nextOption();
        assertEquals(Options.SETTINGS, menu.getSelectedButton().getOption());
        menu.previousOption();
        assertEquals(Options.START, menu.getSelectedButton().getOption());
    }
}

