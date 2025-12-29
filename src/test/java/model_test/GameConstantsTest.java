package model_test;

import model.game.config.GameConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameConstantsTest {

    @Test
    void testConstants() {
        assertEquals(256, GameConstants.GAME_WIDTH);
        assertEquals(160, GameConstants.GAME_HEIGHT);
        assertEquals(40, GameConstants.FPS);
        assertEquals(25, GameConstants.FRAME_TIME);

        GameConstants constants = new GameConstants();
        assertNotNull(constants);
    }
}