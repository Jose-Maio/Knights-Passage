package model.game.config;

public enum Difficulty {
    EASY(0.75, 0.75),
    MEDIUM(1.0, 1.0),
    HARD(1.5, 1.5);

    private final double damageMultiplier;
    private final double healthMultiplier;

    Difficulty(double damageMultiplier, double healthMultiplier) {
        this.damageMultiplier = damageMultiplier;
        this.healthMultiplier = healthMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getHealthMultiplier() {
        return healthMultiplier;
    }
}