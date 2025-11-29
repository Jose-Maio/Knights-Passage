package view;

import gui.Gui;
import model.Position;
import model.entities.characters.enemies.CastleEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.entities.CastleEnemyRenderer;

class CastleEnemyRendererTest {

    private CastleEnemy enemy;
    private CastleEnemyRenderer renderer;
    private Gui gui;

    @BeforeEach
    void setUp() throws Exception {
        enemy = Mockito.mock(CastleEnemy.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(7, 12));

        renderer = new CastleEnemyRenderer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() throws Exception {
        renderer.render(enemy, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/CastleEnemy right.png", enemy.getPosition());
    }
}
