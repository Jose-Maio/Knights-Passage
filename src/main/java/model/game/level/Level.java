package model.game.level;


import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.BloodDrops;
import model.game.Arena;
import model.game.level.CompletionRules.LevelCompletionRule;
import model.game.level.SpecialBehavior.LevelSpecialBehavior;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<Enemy> enemyList;
    private final Arena arena;
    private final Rectangle exitPosition;
    private final Player player;
    private final Position entryPosition;
    private final LevelCompletionRule levelCompletionRule;
    private final LevelSpecialBehavior levelSpecialBehavior;

    public Level(List<Enemy> enemies,  Arena arena, Position entryPosition, Rectangle exitPosition, Player player,
                 LevelCompletionRule levelCompletionRule, LevelSpecialBehavior levelSpecialBehavior){
        this.enemyList = new ArrayList<>(enemies);
        this.arena = arena;
        this.exitPosition = exitPosition;
        this.player = player;
        this.entryPosition = entryPosition;
        this.levelCompletionRule = levelCompletionRule;
        this.levelSpecialBehavior = levelSpecialBehavior;
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

    public List<Position> removeDeadEnemies(){
        List<Position> deadEnemyPositions = new ArrayList<>();
        for(Enemy enemy : enemyList){
            if(enemy.isDead()){
                deadEnemyPositions.add(enemy.getPosition());
            }
        }
        enemyList.removeIf(Enemy::isDead);

        return deadEnemyPositions;

    }

    public void specialBehavior(){
        if(levelSpecialBehavior != null)levelSpecialBehavior.behavior(this);
    }

    public void spawnPlayer(){
        player.setPosition(entryPosition);
    }
}
