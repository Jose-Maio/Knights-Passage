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

    Level createSimpleLevel1() {
        Player p = new Player(20, 5);

        ForestEnemy enemy = new ForestEnemy(new Position(10,10), 10, 2);

        Key key = new Key(new Position(5,5));

        Arena arena = new Arena(List.of(new Tree(new Position(20,20))), "bg");

        return new Level(List.of(enemy), key, arena, new Position(0,0), new Position(100,100), p);
    }

    Level createSimpleLevel2() {
        Player p = new Player(20, 5);

        ForestEnemy enemy = new ForestEnemy(new Position(10,10), 10, 2);

        Key key = new Key(new Position(5,5));

        Arena arena = new Arena(List.of(new Tree(new Position(20,20))), "bg");

        return new Level(List.of(enemy), key, arena, new Position(0,0), new Position(100,100), p);
    }

    Game createSimpleGame() {
        GameConfiguration gc = new GameConfiguration(Difficulty.MEDIUM);
        return new Game(gc);
    }

    @Test
    void testNextLevel() {
        Game g = createSimpleGame();
        int currentLevel = 0;
        List<Level> levels = new ArrayList<>();
        levels.add(createSimpleLevel1());
        levels.add(createSimpleLevel2());
        boolean gameOver = false;
        g.nextLevel();
        g.update();
        assertEquals(levels.get(1),  g.getCurrentLevel());
    }


}
