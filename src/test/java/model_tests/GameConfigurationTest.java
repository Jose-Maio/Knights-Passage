package model_tests;


import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

    @Test
    void testEasyDifficultyMultipliers() {
        GameConfiguration config = new GameConfiguration(Difficulty.EASY);

        assertEquals(Difficulty.EASY, config.getDifficulty());
        assertEquals(0.75, config.getEnemyDamageMultiplier());
        assertEquals(0.75, config.getEnemyHealthMultiplier());
    }

    @Test
    void testMediumDifficultyMultipliers() {
        GameConfiguration config = new GameConfiguration(Difficulty.MEDIUM);

        assertEquals(Difficulty.MEDIUM, config.getDifficulty());
        assertEquals(1.0, config.getEnemyDamageMultiplier());
        assertEquals(1.0, config.getEnemyHealthMultiplier());
    }

    @Test
    void testHardDifficultyMultipliers() {
        GameConfiguration config = new GameConfiguration(Difficulty.HARD);

        assertEquals(Difficulty.HARD, config.getDifficulty());
        assertEquals(1.5, config.getEnemyDamageMultiplier());
        assertEquals(1.5, config.getEnemyHealthMultiplier());
    }
}

