package model_tests;

import model.entities.characters.Player;
import model.game.Game;
import model.game.Level;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import org.junit.jupiter.api.Test;
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

    @Test
    void testGameOverIfPlayerDies(){
        Game g = createSimpleGame();
        Level lvl = g.getCurrentLevel();
        Player p = lvl.getPlayer();
        p.takeDamage(p.getHealth());
        g.update();
        assertTrue(g.isGameOver());
    }

}