package model.game.level;

public class AllEnemiesDeadRule implements  LevelCompletionRule{

    public boolean isComplete(Level level) {
        return level.getEnemyList().isEmpty();
    }
}
