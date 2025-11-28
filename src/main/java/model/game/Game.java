package model.game;

import model.entities.characters.Player;
import model.game.Level;
import model.game.config.GameConfiguration;

import java.util.List;

public class Game {
    private int currentLevel = 0;
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

    public void update(){
        Level level = levels.get(currentLevel);

        if(level.getPlayer().isDead()){
            gameOver = true;
        }
        level.update();

        if(level.isComplete()){
            nextLevel();
        }

        if(gameOver){
            return;
        }

    }

}