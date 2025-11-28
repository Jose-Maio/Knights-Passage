package view_tests;

import gui.Gui;
import model.Position;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ArenaRenderer;

import java.io.IOException;
import java.util.Arrays;

class ArenaRendererTest {

    private Arena arena;
    private Gui gui;
    private ArenaRenderer renderer;

    @BeforeEach
    void setUp() {
        arena = Mockito.mock(Arena.class);
        gui = Mockito.mock(Gui.class);
        renderer = new ArenaRenderer();

        Mockito.when(arena.getBackgroundImg()).thenReturn("bg.png");

        Mockito.when(arena.getObjectList()).thenReturn(Arrays.asList(new Wall(new Position(1, 2)), new Tree(new Position(5, 5)), new Wall(new Position(3, 4))));
    }

    @Test
    void drawBackground() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).fillBackground("bg.png");
    }

    @Test
    void drawWalls() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/wall.png", new Position(1, 2));

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/wall.png", new Position(3, 4));

        // total walls drawn
        Mockito.verify(gui, Mockito.times(2)).drawImage(Mockito.eq("sprites/wall.png"), Mockito.any());
    }

    @Test
    void drawTrees() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/Tree.png", new Position(5, 5));

        Mockito.verify(gui, Mockito.times(1)).drawImage(Mockito.eq("sprites/Tree.png"), Mockito.any());
    }
}
