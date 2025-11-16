package model.game;

import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Arena;

import java.util.List;

public class Game {
    private final Arena arena;
    private final Player player;
    private final List<Enemy> enemies;
    private int level;


    public Game(Arena arena, Player player, List<Enemy> enemies) {
        this.arena = arena;
        this.player = player;
        this.enemies = enemies;
        this.level = 1; // when opening the game, the level is set to the first one
    }

    public Arena getArena(){
        return arena;
    }

    public Player getPlayer(){
        return player;
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public int getLevel(){
        return level;
    }

    public int nextLevel(){
        level++;
        return level; // except for the case where level == 4, in that case, next level is game over
    }
}