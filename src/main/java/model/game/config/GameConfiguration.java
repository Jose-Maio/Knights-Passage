package model.game.config;

public class GameConfiguration {
    private final Difficulty difficulty;
    private final double enemyDamageMultiplier;
    private final double enemyHealthMultiplier;

    public GameConfiguration(Difficulty difficulty){
        this.difficulty = difficulty;

        switch (difficulty){
            case EASY:
                enemyDamageMultiplier = 0.75;
                enemyHealthMultiplier = 0.75;
                break;
            case MEDIUM:
                enemyDamageMultiplier = 1;
                enemyHealthMultiplier = 1;
                break;
            case HARD:
                enemyDamageMultiplier = 1.5;
                enemyHealthMultiplier = 1.5;
                break;
            default:
                enemyDamageMultiplier = 1;
                enemyHealthMultiplier = 1;
                break;
        }
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public double getEnemyDamageMultiplier() {
        return enemyDamageMultiplier;
    }

    public double getEnemyHealthMultiplier() {
        return enemyHealthMultiplier;
    }
}
