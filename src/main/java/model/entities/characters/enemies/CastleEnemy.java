package model.entities.characters.enemies;

import model.Position;

import java.awt.*;

public class CastleEnemy extends Enemy {
    public CastleEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
    }

    @Override
    public String toStringImg() {
        return "CastleEnemy " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";}
                + (attacking ? " attack" : "");
    }
}
