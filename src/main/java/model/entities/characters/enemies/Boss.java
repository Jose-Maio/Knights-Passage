package model.entities.characters.enemies;

import model.Position;

public class Boss extends Enemy {
    public Boss(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
    }
}
