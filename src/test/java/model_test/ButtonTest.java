package model_test;

import model.Button;
import model.Options;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonTest {

    private Button button;

    @BeforeEach
    void setUp() {
        button = new Button(Options.START, new Position(10, 10));
    }

    @Test
    void testConstructor() {
        assertEquals(Options.START, button.getOption());
        assertEquals(10, button.getPosition().getX());
        assertEquals(10, button.getPosition().getY());
        assertFalse(button.isHovered());
    }

    @Test
    void testSetHovered() {
        button.setHovered(true);
        assertTrue(button.isHovered());
    }

    @Test
    void testToStringImg() {
        assertEquals("START", button.toStringImg());
        button.setHovered(true);
        assertTrue(button.toStringImg().contains("_selected"));
    }

    @Test
    void testSetOption() {
        button.setOption(Options.EXIT);
        assertEquals(Options.EXIT, button.getOption());
    }
}

