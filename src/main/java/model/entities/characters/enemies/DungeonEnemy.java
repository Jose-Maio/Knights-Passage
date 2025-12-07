package model.entities.characters.enemies;

import model.Position;

public class DungeonEnemy extends Enemy {
    public DungeonEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
    }

    @Override
    public String toStringImg() {
        return "DungeonEnemy " + switch (getFacing()){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";

    };
    }
}
