package model.game.level;

public class RemoveObject implements LevelSpecialBehavior{

    @Override
    public void behavior(Level level) {
        if(level.getEnemyList().isEmpty()){
            level.getArena().getObjectList().clear();
        }
    }
}
