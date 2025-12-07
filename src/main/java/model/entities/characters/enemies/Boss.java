package model.entities.characters.enemies;

import model.Position;

import java.awt.*;

public class Boss extends Enemy {
    public Boss(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
    }

    @Override
    public Rectangle getHitbox() {
        return null;
    }
}
