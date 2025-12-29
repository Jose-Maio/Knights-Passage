package view;

import gui.Gui;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.entities.CharacterRenderer;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

class LevelRendererTest {
    private LevelRenderer levelRenderer;
    private Gui gui;
    private Level level;
    private Arena arena;
    private Player player;

    @BeforeEach
    void setUp() {
        levelRenderer = new LevelRenderer();

        levelRenderer.characterRenderer = mock(CharacterRenderer.class);
        levelRenderer.arenaRenderer = mock(ArenaRenderer.class);
        levelRenderer.healthBarRenderer = mock(HealthBarRenderer.class);

        gui = mock(Gui.class);
        level = mock(Level.class);
        arena = mock(Arena.class);
        player = mock(Player.class);

        when(level.getArena()).thenReturn(arena);
        when(level.getPlayer()).thenReturn(player);
    }

    @Test
    void testRenderCallsSubRenderers() throws IOException {
        Enemy enemy = mock(Enemy.class);
        when(level.getEnemyList()).thenReturn(List.of(enemy));

        levelRenderer.render(level, gui);

        verify(levelRenderer.arenaRenderer).render(arena, gui);

        verify(levelRenderer.characterRenderer).render(player, gui);
        verify(levelRenderer.healthBarRenderer).render(player, gui);

        verify(levelRenderer.characterRenderer).render(enemy, gui);
        verify(levelRenderer.healthBarRenderer).render(enemy, gui);
    }

    @Test
    void testLevelTransitionResetsBuffer() throws IOException {
        Level secondLevel = mock(Level.class);
        when(secondLevel.getArena()).thenReturn(mock(Arena.class));
        when(secondLevel.getPlayer()).thenReturn(player);
        when(secondLevel.getEnemyList()).thenReturn(List.of());

        levelRenderer.render(level, gui);
        verify(levelRenderer.arenaRenderer, never()).resetArenaBuffer();

        levelRenderer.render(level, gui);
        verify(levelRenderer.arenaRenderer, never()).resetArenaBuffer();

        levelRenderer.render(secondLevel, gui);
        verify(levelRenderer.arenaRenderer, times(1)).resetArenaBuffer();
    }
}