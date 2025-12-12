package view;

import gui.Gui;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class LevelRendererTest {

    private Level level;
    private Gui gui;
    private LevelRenderer renderer;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(Gui.class);

        Arena arena = Mockito.mock(Arena.class);
        Player player = Mockito.mock(Player.class);
        Key key = Mockito.mock(Key.class);

        ForestEnemy e1 = Mockito.mock(ForestEnemy.class);
        ForestEnemy e2 = Mockito.mock(ForestEnemy.class);

        level = Mockito.mock(Level.class);

        Mockito.when(level.getArena()).thenReturn(arena);
        Mockito.when(level.getPlayer()).thenReturn(player);
        //Mockito.when(level.getKey()).thenReturn(key);
        Mockito.when(level.getEnemyList()).thenReturn(Arrays.asList(e1, e2));

        renderer = new LevelRenderer();
    }

    @Test
    void renderCallsArena() throws IOException {
        renderer.render(level, gui);

        Mockito.verify(gui, Mockito.atLeastOnce()).drawImage(Mockito.anyString(), Mockito.any());
    }


    @Test
    void renderDrawsEnemies() throws IOException {
        renderer.render(level, gui);

        // should check if 2 enemies are drawn
        Mockito.verify(gui, Mockito.atLeast(2)).drawImage(Mockito.anyString(), Mockito.any());
    }
}

