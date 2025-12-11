package model.game.level.CompletionRules;

import model.game.level.Level;

public class KeyCollectedRule implements LevelCompletionRule {


    public boolean isComplete(Level level) {
        return level.getPlayer().hasKey();
    }
}
