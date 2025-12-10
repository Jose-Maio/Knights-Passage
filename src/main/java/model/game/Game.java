package model.game;


import model.Direction;
import model.game.config.GameConfiguration;

import java.util.List;

public class Game {
    private int currentLevel = 3;
    private final List<Level> levels;
    private boolean gameOver = false;

    public Game(GameConfiguration configuration) {

        LevelFactory factory = LevelFactory.getInstance(configuration);
        this.levels = factory.getLevels();
    }

    public Level getCurrentLevel() {
        return levels.get(currentLevel);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void nextLevel() {

        if (currentLevel == levels.size() - 1)
            gameOver = true;
        else currentLevel++;

    }

    public void setGameOver() {
        this.gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }


}