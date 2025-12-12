package model.game.level.CompletionRules;

import model.game.level.Level;

public interface LevelCompletionRule {
    boolean isComplete(Level level);

}
