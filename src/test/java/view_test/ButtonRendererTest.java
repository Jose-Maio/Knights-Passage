package view_test;

import gui.Gui;
import model.Button;
import model.Options;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ButtonRenderer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ButtonRendererTest {

    private ButtonRenderer buttonRenderer;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        buttonRenderer = new ButtonRenderer();
        mockGui = mock(Gui.class);
    }

    @Test
    void testGetImgPath() {
        Button button = new Button(Options.START, new Position(10, 10));
        String path = buttonRenderer.getImgPath(button);
        assertTrue(path.contains("sprites/menu/buttons/"));
        assertTrue(path.contains(".png"));
    }

    @Test
    void testRender() throws Exception {
        Button button = new Button(Options.START, new Position(10, 10));
        buttonRenderer.render(button, mockGui);
        verify(mockGui).drawImage(anyString(), eq(button.getPosition()));
    }
}
