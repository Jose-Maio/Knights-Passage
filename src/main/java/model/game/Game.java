package model.game;


import model.entities.characters.Player;
import model.game.config.GameConfiguration;
import model.game.level.Level;
import model.game.level.LevelFactory;

import java.util.List;

public class Game {
    private int currentLevel = 0;
    private final List<Level> levels;
    private boolean gameOver = false;
    private boolean win = false;

    public Game(GameConfiguration configuration) {
        LevelFactory factory = new LevelFactory(configuration);
        Player player = new Player(500, 10);
        this.levels = factory.getLevels(player);
    }

    public Level getCurrentLevel() {
        return levels.get(currentLevel);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void nextLevel() {

        if (currentLevel == levels.size() - 1){
            gameOver = true;
            win = true;
        }

        else currentLevel++;

    }

    public void setGameOver() {
        this.gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isWin() {
        return win;
    }
}