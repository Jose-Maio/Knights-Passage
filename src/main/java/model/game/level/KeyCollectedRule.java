package model.game.level;

public class KeyCollectedRule implements LevelCompletionRule{


    public boolean isComplete(Level level) {
        return level.getPlayer().hasKey();
    }
}
