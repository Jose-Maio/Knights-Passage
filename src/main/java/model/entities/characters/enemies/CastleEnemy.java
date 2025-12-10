package model.entities.characters.enemies;

import model.Position;

public class CastleEnemy extends Enemy {
    public CastleEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
    }

    @Override
    public String toStringImg() {
        return "CastleEnemy " + switch (getFacing()){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";

    };
    }
}
