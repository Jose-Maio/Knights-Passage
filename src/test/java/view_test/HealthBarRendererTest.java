package view_test;

import gui.Gui;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.enemies.Boss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.HealthBarRenderer;


import java.io.IOException;
import static org.mockito.Mockito.*;

class HealthBarRendererTest {
    private HealthBarRenderer renderer;
    private Gui gui;
    private Character character;
    private Boss boss;

    @BeforeEach
    void setUp() {
        renderer = new HealthBarRenderer();
        gui = mock(Gui.class);
        character = mock(Character.class);
        boss = mock(Boss.class);
    }

    @Test
    void testCalculatePosition() throws IOException {
        when(character.getPosition()).thenReturn(new Position(10, 1));
        when(character.getHealth()).thenReturn(10);
        when(character.getMaxHealth()).thenReturn(10);

        renderer.render(character, gui);
        verify(gui).drawImage(anyString(), eq(new Position(10, 18)));

        reset(gui);
        when(character.getPosition()).thenReturn(new Position(10, 5));
        renderer.render(character, gui);
        verify(gui).drawImage(anyString(), eq(new Position(10, 4)));
    }

    @Test
    void testGetHealthBarImgPathRegular() throws IOException {
        when(character.getPosition()).thenReturn(new Position(0, 5));

        String[] expectedPaths = {
                "sprites/characters/health_bars/health_1_5.png", // 20%
                "sprites/characters/health_bars/health_2_5.png", // 40%
                "sprites/characters/health_bars/health_3_5.png", // 60%
                "sprites/characters/health_bars/health_4_5.png", // 80%
                "sprites/characters/health_bars/health_full.png" // 100%
        };
        double[] percentages = {0.20, 0.40, 0.60, 0.80, 1.0};

        for (int i = 0; i < percentages.length; i++) {
            reset(gui);
            when(character.getMaxHealth()).thenReturn(100);
            when(character.getHealth()).thenReturn((int) (100 * percentages[i]));

            renderer.render(character, gui);
            verify(gui).drawImage(eq(expectedPaths[i]), any(Position.class));
        }
    }

    @Test
    void testGetBossHealthBarImgPath() throws IOException {
        when(boss.getPosition()).thenReturn(new Position(0, 5));
        when(boss.getMaxHealth()).thenReturn(100);

        String[] expectedPaths = {
                "sprites/characters/health_bars/boss_health_1_10.png",
                "sprites/characters/health_bars/boss_health_2_10.png",
                "sprites/characters/health_bars/boss_health_3_10.png",
                "sprites/characters/health_bars/boss_health_4_10.png",
                "sprites/characters/health_bars/boss_health_5_10.png",
                "sprites/characters/health_bars/boss_health_6_10.png",
                "sprites/characters/health_bars/boss_health_7_10.png",
                "sprites/characters/health_bars/boss_health_8_10.png",
                "sprites/characters/health_bars/boss_health_9_10.png",
                "sprites/characters/health_bars/boss_health_full.png"
        };

        for (int i = 0; i < expectedPaths.length; i++) {
            reset(gui);
            double percentage = (i + 1) * 0.10;
            int health = (i == 9) ? 100 : (int)(100 * percentage);
            when(boss.getHealth()).thenReturn(health);

            renderer.render(boss, gui);
            verify(gui).drawImage(eq(expectedPaths[i]), any(Position.class));
        }
    }
}