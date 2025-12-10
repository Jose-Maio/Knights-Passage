package model.game.level;


import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Arena;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<Enemy> enemyList;
    private final Arena arena;
    private final Rectangle exitPosition;
    private final Player player;
    private final Position entryPoition;
    private final LevelCompletionRule levelCompletionRule;

    public Level(List<Enemy> enemies,  Arena arena, Position entryPosition, Rectangle exitPosition, Player player, LevelCompletionRule levelCompletionRule){
        this.enemyList = new ArrayList<>(enemies);
        this.arena = arena;
        this.exitPosition = exitPosition;
        this.player = player;
        this.player.setPosition(entryPosition);
        this.entryPoition = entryPosition;
        this.levelCompletionRule = levelCompletionRule;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public Arena getArena() {
        return arena;
    }


    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getCloseEnemyList(){
        List<Enemy> closeEnemy = new ArrayList<>();
        for(Enemy enemy : enemyList){
            if(enemy.getVision().intersects(player.getHitbox())){
                closeEnemy.add(enemy);
            }
        }
        return closeEnemy;
    }

    public boolean isComplete(){

        return levelCompletionRule.isComplete(this) && player.getHitbox().intersects(exitPosition);
    }

    public void removeDeadEnemies(){
        enemyList.removeIf(Enemy::isDead);

    }

    public Position getEntryPoition() {
        return entryPoition;
    }
}
