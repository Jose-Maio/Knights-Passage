package model.game.level.CompletionRules;

import model.game.level.Level;

public class AllEnemiesDeadRule implements LevelCompletionRule {

    public boolean isComplete(Level level) {
        return level.getEnemyList().isEmpty();
    }
}
