package model.game;

import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Key;
import model.entities.objects.Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<Enemy> enemyList;
    private final Key key;
    private final Arena arena;
    private final Position entryPosition;
    private final Position exitPosition;
    private final Player player;

    public Level(List<Enemy> enemies, Key key, Arena arena, Position entryPosition, Position exitPosition, Player player){
        this.enemyList = new ArrayList<>(enemies);
        this.key = key;
        this.arena = arena;
        this.entryPosition = entryPosition;
        this.exitPosition = exitPosition;
        this.player = player;
        this.player.setPosition(entryPosition);
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public Arena getArena() {
        return arena;
    }

    public Key getKey() {
        return key;
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

    public boolean checkPlayerCollisions(Rectangle newHitbox){


        for(Object object : arena.getObjectList()){
            if(object.isSolid() && object.getHitbox().intersects(newHitbox)){
                return true;
            }
        }

        for(Enemy enemy : getCloseEnemyList()){
            if(enemy.getHitbox().intersects(newHitbox)){
                return true;
            }
        }
        return false;

    }

    public void update(Direction direction){
        Position newPosition = player.nextPos(direction);
        Rectangle newHitbox = new Rectangle(newPosition.getX(), newPosition.getY(), 16, 16);
        if(!checkPlayerCollisions(newHitbox)){
            player.move(direction);
        }

        if(player.getHitbox().intersects(key.getHitbox())) player.pickUpKey();

        List<Enemy> closeEnemy = getCloseEnemyList();

        for (int i = 0; i < closeEnemy.size(); i++) {
            Enemy enemy = closeEnemy.get(i);
            enemy.update();
            if (enemy.isDead()) {
                closeEnemy.remove(i);
                i--;
            }
        }


    }

    public boolean isComplete(){

        return player.hasKey() && player.getHitbox().intersects(new Rectangle(exitPosition.getX(), exitPosition.getY()));
    }
}
