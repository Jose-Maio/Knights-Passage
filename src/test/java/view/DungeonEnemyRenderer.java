package view;

import gui.Gui;
import model.Position;
import model.entities.characters.enemies.DungeonEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.entities.enemies.DungeonEnemyRenderer;

class DungeonEnemyRendererTest {

    private DungeonEnemy enemy;
    private DungeonEnemyRenderer renderer;
    private Gui gui;

    @BeforeEach
    void setUp() throws Exception {
        enemy = Mockito.mock(DungeonEnemy.class);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(7, 12));

        renderer = new DungeonEnemyRenderer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() throws Exception {
        renderer.render(enemy, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/characters/DungeonEnemy right.png", enemy.getPosition());
    }
}
