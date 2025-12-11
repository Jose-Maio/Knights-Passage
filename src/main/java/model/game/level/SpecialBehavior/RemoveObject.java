package model.game.level.SpecialBehavior;

import model.entities.objects.Key;
import model.game.level.Level;

public class RemoveObject implements LevelSpecialBehavior {

    @Override
    public void behavior(Level level) {
        if (level.getEnemyList().isEmpty()) {
            level.getArena().getObjectList().removeIf(obj -> !(obj instanceof Key));
        }
    }
}
