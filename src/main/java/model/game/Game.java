package model.game;

import model.entities.characters.Player;
import model.game.Level;

import java.util.List;

public class Game {
    private int current_level;
    private final Player player;
    private final List<Level> levels;

    public Game(int current_level, Player player, List<Level> levels) {
        this.current_level = current_level;
        this.player = player;
        this.levels = levels;
    }

    public int getCurrent_level() {
        return current_level;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public Level nextLevel() {
        Level current = levels.get(current_level);

        if (!current.isComplete()) return current;

        if (current_level == levels.size() - 1)
            return current; // or game over

        current_level++;

        return levels.get(current_level);
    }

}