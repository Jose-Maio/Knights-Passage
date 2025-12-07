package model.entities.characters.enemies;

import model.Direction;
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

    @Override
    public String toStringImg() {
        return "Boss " + switch (getFacing()){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";
        };
    }
}


