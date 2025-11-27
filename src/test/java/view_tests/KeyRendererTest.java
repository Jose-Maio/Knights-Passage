package view_tests;

import gui.LanternaGui;
import model.Position;
import model.entities.objects.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.entities.KeyRenderer;

class KeyRendererTest {

    private Key key;
    private KeyRenderer renderer;
    private LanternaGui gui;

    @BeforeEach
    void setUp() throws Exception {
        key = Mockito.mock(Key.class);
        Mockito.when(key.getPosition()).thenReturn(new Position(5, 15));

        renderer = new KeyRenderer();
        gui = Mockito.mock(LanternaGui.class);
    }

    @Test
    void drawElement() throws Exception {
        renderer.render(key, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/Key.png", key.getPosition());
    }
}
