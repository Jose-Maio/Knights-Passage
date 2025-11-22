package model.game;

import model.entities.characters.Player;
import model.game.Level;

import java.util.List;

public class Game {
    private int currentLevel = 0;
    private final Player player;
    private final List<Level> levels;
    private boolean gameOver = false;

    public Game(int current_level, Player player, List<Level> levels) {
        this.currentLevel = current_level;
        this.player = player;
        this.levels = levels;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void nextLevel() {

        if (currentLevel == levels.size() - 1)
            gameOver = true; // or game over

        else currentLevel++;

    }

    public void setGameOver() {
        this.gameOver = true;
    }

    public void update(){
        if(player.isDead()){
            gameOver = true;
        }

        Level level = levels.get(currentLevel);
        level.update();

        if(level.isComplete()){
            nextLevel();
        }

        if(gameOver){
            return;
        }

    }

}