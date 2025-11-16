package model.entities.characters;

public interface Damageable {
    void takeDamage(int amount);
    boolean isDead();
}
