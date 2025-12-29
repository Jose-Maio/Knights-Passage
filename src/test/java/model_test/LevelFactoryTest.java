package model_test;

import model.entities.characters.Player;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.Level;
import model.game.level.LevelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LevelFactoryTest {

    private LevelFactory levelFactory;
    private Player mockPlayer;

    @BeforeEach
    void setUp() {
        GameConfiguration config = new GameConfiguration(Difficulty.MEDIUM);
        levelFactory = new LevelFactory(config);
        mockPlayer = mock(Player.class);
    }

    @Test
    void testCreateLevel1() {
        Level level = levelFactory.createLevel1(mockPlayer);
        assertNotNull(level);
        assertEquals(mockPlayer, level.getPlayer());
        assertFalse(level.getEnemyList().isEmpty());
    }

    @Test
    void testCreateLevel2() {
        Level level = levelFactory.createLevel2(mockPlayer);
        assertNotNull(level);
        assertEquals(mockPlayer, level.getPlayer());
        assertFalse(level.getEnemyList().isEmpty());
    }

    @Test
    void testCreateLevel3() {
        Level level = levelFactory.createLevel3(mockPlayer);
        assertNotNull(level);
        assertEquals(mockPlayer, level.getPlayer());
        assertFalse(level.getEnemyList().isEmpty());
    }

    @Test
    void testCreateLevel4() {
        Level level = levelFactory.createLevel4(mockPlayer);
        assertNotNull(level);
        assertEquals(mockPlayer, level.getPlayer());
        // Level 4 IS a Boss level so it should have enemies
        assertFalse(level.getEnemyList().isEmpty());
    }

    @Test
    void testGetLevels() {
        var levels = levelFactory.getLevels(mockPlayer);
        assertEquals(4, levels.size());
    }
}
