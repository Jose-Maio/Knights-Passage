package view;

import gui.Gui;
import model.Position;
import model.entities.characters.enemies.Boss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.entities.enemies.BossRenderer;


class BossRendererTest {

    private Boss enemy;
    private BossRenderer renderer;
    private Gui gui;

    @BeforeEach
    void setUp() throws Exception {
        enemy = Mockito.mock(Boss.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(7, 12));

        renderer = new BossRenderer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() throws Exception {
        renderer.render(enemy, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/characters/Boss right.png", enemy.getPosition());
    }
}
