package model.game.config;

public class GameConfiguration {
    private final Difficulty difficulty;
    private final double enemyDamageMultiplier;
    private final double enemyHealthMultiplier;

    public GameConfiguration(Difficulty difficulty){
        this.difficulty = difficulty;
        this.enemyDamageMultiplier = difficulty.getDamageMultiplier();
        this.enemyHealthMultiplier = difficulty.getHealthMultiplier();
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
