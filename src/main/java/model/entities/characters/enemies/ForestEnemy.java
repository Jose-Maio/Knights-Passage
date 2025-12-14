package model.entities.characters.enemies;

import model.Position;

import java.awt.*;


public class ForestEnemy extends Enemy {

    private static final int ENEMY_HITBOX_SIZE = 12;
    private static final long FOREST_ATTACK_DELAY = 300;

    public ForestEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage, ENEMY_HITBOX_SIZE, ENEMY_HITBOX_SIZE, FOREST_ATTACK_DELAY);
    }

    @Override
    public String toStringImg() {
        return "ForestEnemy " + switch (facing) {
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "";
        } + (attacking ? " attack" : "");

    }

}
