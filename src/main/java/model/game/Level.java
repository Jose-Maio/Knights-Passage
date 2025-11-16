package model.game;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Key;

import java.util.List;

public class Level {
    private final List<Enemy> enemyList;
    private final Key key;
    private final Arena arena;
    private final Position entryPosition;
    private final Position exitPosition;
    private final Player player;

    Level(List<Enemy> enemies, Key key, Arena arena, Position entryPosition, Position exitPosition, Player player){
        enemyList = enemies;
        this.key = key;
        this.arena = arena;
        this.entryPosition = entryPosition;
        this.exitPosition = exitPosition;
        this.player = player;
        this.player.setPosition(entryPosition);
    }

    public void update(){
        if(player.getPosition().equals(key.getPosition())) player.pickUpKey();
        enemyList.forEach(Enemy::update);
        enemyList.removeIf(Enemy::isDead);
    }

    boolean isComplete(){
        return player.hasKey() && player.getPosition().equals(exitPosition);
    }





}
