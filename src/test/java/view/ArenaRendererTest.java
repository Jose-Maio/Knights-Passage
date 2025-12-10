package view;

import gui.Gui;
import model.Position;
import model.entities.objects.BigWallH;
import model.entities.objects.Tree;
import model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        Mockito.when(arena.getObjectList()).thenReturn(Arrays.asList(new BigWallH(new Position(1, 2)), new Tree(new Position(5, 5)), new BigWallH(new Position(3, 4))));
    }

    @Test
    void drawBackground() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).fillBackground("bg.png");
    }

    @Test
    void drawWalls() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/objects/Wall.png", new Position(1, 2));

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/objects/Wall.png", new Position(3, 4));

        // total walls drawn
        Mockito.verify(gui, Mockito.times(2)).drawImage(Mockito.eq("sprites/objects/Wall.png"), Mockito.any());
    }

    @Test
    void drawTrees() throws IOException {
        renderer.render(arena, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/objects/Tree.png", new Position(5, 5));

        Mockito.verify(gui, Mockito.times(1)).drawImage(Mockito.eq("sprites/objects/Tree.png"), Mockito.any());
    }
}
