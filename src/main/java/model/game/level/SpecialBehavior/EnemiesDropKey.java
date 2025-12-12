package model.game.level.SpecialBehavior;

import model.entities.objects.Key;
import model.game.level.Level;


public class EnemiesDropKey implements LevelSpecialBehavior {

    private final Key key;
    private boolean keyDropped = false;

    public EnemiesDropKey(Key key){
        this.key = key;
    }

    @Override
    public void behavior(Level level) {
        if(!keyDropped){
            if(level.getEnemyList().isEmpty()){
                level.getArena().placeKey(key);
                keyDropped = true;
            }

        }
    }
}
