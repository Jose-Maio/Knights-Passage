package model.game;


import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<Enemy> enemyList;
    private final Arena arena;
    private final Rectangle exitPosition;
    private final Player player;
    private final Position entryPoition;

    public Level(List<Enemy> enemies,  Arena arena, Position entryPosition, Rectangle exitPosition, Player player){
        this.enemyList = new ArrayList<>(enemies);
        this.arena = arena;
        this.exitPosition = exitPosition;
        this.player = player;
        this.player.setPosition(entryPosition);
        this.entryPoition = entryPosition;
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

        return player.hasKey() && player.getHitbox().intersects(exitPosition);
    }

    public void removeDeadEnemies(){
        enemyList.removeIf(Enemy::isDead);

    }

    public Position getEntryPoition() {
        return entryPoition;
    }
}
