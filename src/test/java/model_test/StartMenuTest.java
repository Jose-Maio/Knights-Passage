package model_test;

import model.Options;
import model.game.menu.StartMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartMenuTest {

    private StartMenu menu;

    @BeforeEach
    void setUp() {
        menu = new StartMenu();
    }

    @Test
    void testConstructor() {
        assertEquals(4, menu.getButtons().size());
        assertEquals(Options.START, menu.getSelectedButton().getOption());

        assertTrue(menu.getButtons().get(0).isHovered());
    }

    @Test
    void testNavigationNext() {

        menu.nextOption();
        assertEquals(Options.SETTINGS, menu.getSelectedButton().getOption());

        menu.nextOption();
        assertEquals(Options.CONTROLS, menu.getSelectedButton().getOption());

        menu.nextOption();
        assertEquals(Options.EXIT, menu.getSelectedButton().getOption());

        menu.nextOption();
        assertEquals(Options.START, menu.getSelectedButton().getOption());
    }

    @Test
    void testNavigationPrevious() {

        menu.previousOption();
        assertEquals(Options.EXIT, menu.getSelectedButton().getOption());

        menu.previousOption();
        assertEquals(Options.CONTROLS, menu.getSelectedButton().getOption());
    }

    @Test
    void testSelectionState() {
        assertFalse(menu.isSelected());
        menu.setSelected(true);
        assertTrue(menu.isSelected());
    }

    @Test
    void testResetSelection() {
        menu.previousOption();
        menu.setSelected(true);

        menu.resetSelection();

        assertEquals(Options.START, menu.getSelectedButton().getOption());
        assertFalse(menu.isSelected());
        assertTrue(menu.getButtons().get(0).isHovered());
        assertFalse(menu.getButtons().get(3).isHovered());
    }

    @Test
    void testGetBackgroundImg() {
        assertNotNull(menu.getBackgroundImg());
        assertFalse(menu.getBackgroundImg().isEmpty());
    }
}