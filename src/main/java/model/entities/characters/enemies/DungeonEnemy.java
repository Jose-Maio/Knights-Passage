package model.entities.characters.enemies;

import model.Position;

import java.awt.*;

public class DungeonEnemy extends Enemy {
    private static final int ENEMY_HITBOX_SIZE = 12;
    private static final long DUNGEON_ATTACK_DELAY = 500;

    public DungeonEnemy(Position startPosition, int health, int damage) {
        super(startPosition, health, damage, ENEMY_HITBOX_SIZE, ENEMY_HITBOX_SIZE, DUNGEON_ATTACK_DELAY);
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
