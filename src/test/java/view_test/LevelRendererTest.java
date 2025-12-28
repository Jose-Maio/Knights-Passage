package view_test;

import gui.Gui;
import model.Position;
import model.entities.characters.Player;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.LevelRenderer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class LevelRendererTest {

    private LevelRenderer levelRenderer;
    private Level mockLevel;
    private Gui mockGui;
    private Arena mockArena;
    private Player mockPlayer;

    @BeforeEach
    void setUp() {
        levelRenderer = new LevelRenderer();
        mockLevel = mock(Level.class);
        mockGui = mock(Gui.class);
        mockArena = mock(Arena.class);
        mockPlayer = mock(Player.class);

        when(mockGui.getWidth()).thenReturn(200);
        when(mockGui.getHeight()).thenReturn(200);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        when(mockLevel.getEnemyList()).thenReturn(new java.util.ArrayList<>());
        when(mockArena.getBackgroundImg()).thenReturn("bg.png");
        when(mockArena.getStaticObjectList()).thenReturn(new java.util.ArrayList<>());
        when(mockArena.getDynamicObjectList()).thenReturn(new java.util.ArrayList<>());
        when(mockPlayer.getPosition()).thenReturn(new Position(10, 10));
        when(mockPlayer.getHealth()).thenReturn(100);
        when(mockPlayer.getMaxHealth()).thenReturn(100);
        when(mockPlayer.getHitbox()).thenReturn(new java.awt.Rectangle(10, 10, 12, 12));
        when(mockPlayer.toStringImg()).thenReturn("Knight right");
    }

    @Test
    void testRender() throws Exception {
        assertDoesNotThrow(() -> levelRenderer.render(mockLevel, mockGui));
        verify(mockLevel, atLeastOnce()).getArena();
        verify(mockLevel, atLeastOnce()).getPlayer();
    }
}
