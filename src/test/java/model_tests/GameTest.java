package model_tests;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.Game;
import model.game.Level;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    Game createSimpleGame() {
        GameConfiguration gc = new GameConfiguration(Difficulty.MEDIUM);
        return new Game(gc);
    }

    @Test
    void testNextLevel() {
        Game g = createSimpleGame();
        g.nextLevel();
        g.update();
        assertTrue(g.isGameOver());
    }

}