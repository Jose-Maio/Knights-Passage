package view_test;

import gui.Gui;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.enemies.Boss;
import model.entities.characters.enemies.ForestEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.HealthBarRenderer;

import static org.mockito.Mockito.*;

class HealthBarRendererTest {

    private HealthBarRenderer healthBarRenderer;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        healthBarRenderer = new HealthBarRenderer();
        mockGui = mock(Gui.class);
    }

    @Test
    void testRenderWithEnemy() throws Exception {
        ForestEnemy enemy = new ForestEnemy(new Position(10, 10), 100, 5);
        healthBarRenderer.render(enemy, mockGui);
        verify(mockGui).drawImage(anyString(), any(Position.class));
    }

    @Test
    void testRenderWithBoss() throws Exception {
        Boss boss = new Boss(new Position(10, 10), 200, 10);
        healthBarRenderer.render(boss, mockGui);
        verify(mockGui).drawImage(anyString(), any(Position.class));
    }
}
