package model.entities.characters.enemies;

import model.Position;

import java.awt.*;

public class CastleEnemy extends Enemy {
    private static final int ENEMY_HITBOX_SIZE = 12;
    private static final long CASTLE_ATTACK_DELAY = 600;

    public CastleEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage, ENEMY_HITBOX_SIZE, ENEMY_HITBOX_SIZE, CASTLE_ATTACK_DELAY);
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
