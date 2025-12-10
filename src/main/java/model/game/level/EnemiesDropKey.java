package model.game.level;

import model.entities.objects.Key;


public class EnemiesDropKey implements LevelSpecialBehavior{

    private final Key key;

    EnemiesDropKey(Key key){
        this.key = key;
    }

    @Override
    public void behavior(Level level) {
        if(level.getEnemyList().isEmpty()){
            level.getArena().placeKey(key);
        }

    }
}
