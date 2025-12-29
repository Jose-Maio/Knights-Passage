package controller_test;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import controller.menu.AbstractMenuController;
import gui.Gui;
import model.game.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuControllerTest {
    private Gui mockGui;
    private Menu mockMenu;
    private StubMenuController controller;

    private static class StubMenuController extends AbstractMenuController<String, Menu> {
        public StubMenuController(Menu menu, Gui gui) {
            super(menu, gui);
        }

        @Override
        public String update() {
            return "Updated";
        }
    }

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        mockMenu = mock(Menu.class);
        controller = new StubMenuController(mockMenu, mockGui);
    }

    @Test
    void testStartLoopAndExit() throws Exception {

        when(mockMenu.isSelected()).thenReturn(false, true);

        String result = controller.start();

        verify(mockMenu, atLeastOnce()).isSelected();
        assertEquals("Updated", result);
    }

    @Test
    void testHandleInputArrowUp() throws IOException {
        KeyStroke upStroke = new KeyStroke(KeyType.ArrowUp);
        when(mockGui.step()).thenReturn(upStroke);

        controller.handleInput();

        verify(mockMenu).previousOption();
    }

    @Test
    void testHandleInputArrowDown() throws IOException {
        KeyStroke downStroke = new KeyStroke(KeyType.ArrowDown);
        when(mockGui.step()).thenReturn(downStroke);

        controller.handleInput();

        verify(mockMenu).nextOption();
    }

    @Test
    void testHandleInputEnter() throws IOException {
        KeyStroke enterStroke = new KeyStroke(KeyType.Enter);
        when(mockGui.step()).thenReturn(enterStroke);

        controller.handleInput();

        verify(mockMenu).setSelected(true);
    }

    @Test
    void testHandleInputNull() throws IOException {
        when(mockGui.step()).thenReturn(null);

        controller.handleInput();

        verifyNoInteractions(mockMenu);
    }
}