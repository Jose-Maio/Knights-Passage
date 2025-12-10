package model.entities.characters.enemies;

import model.Position;



public class ForestEnemy extends Enemy {

    public ForestEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
    }

    @Override
    public String toStringImg() {
        return "ForestEnemy " + switch (getFacing()) {
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";
        } + (isAttacking()? " attack" : "");

    }

}
