package model.entities.characters.enemies;

import model.Position;

import java.awt.*;

public class DungeonEnemy extends Enemy {
    public DungeonEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        this.attackDelay = 500;
    }

    @Override
    public String toStringImg() {
        return "DungeonEnemy " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";

    } + (attacking ? " attack" : "");
    }
}
