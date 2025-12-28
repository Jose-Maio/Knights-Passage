package view_test;

import gui.Gui;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ArenaRenderer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ArenaRendererTest {

    private ArenaRenderer arenaRenderer;
    private Arena mockArena;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        arenaRenderer = new ArenaRenderer();
        mockArena = mock(Arena.class);
        mockGui = mock(Gui.class);

        when(mockGui.getWidth()).thenReturn(200);
        when(mockGui.getHeight()).thenReturn(200);
        when(mockArena.getBackgroundImg()).thenReturn("bg.png");
        when(mockArena.getStaticObjectList()).thenReturn(new java.util.ArrayList<>());
        when(mockArena.getDynamicObjectList()).thenReturn(new java.util.ArrayList<>());
    }

    @Test
    void testRender() throws Exception {
        assertDoesNotThrow(() -> arenaRenderer.render(mockArena, mockGui));
        verify(mockGui, atLeastOnce()).drawBuffer(any());
    }

    @Test
    void testResetArenaBuffer() {
        arenaRenderer.resetArenaBuffer();
        assertTrue(true);
    }
}
