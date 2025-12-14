package model.entities.characters.enemies;


import model.Position;


public class Boss extends Enemy {
    private static final int BOSS_HITBOX_WIDTH = 39;
    private static final int BOSS_HITBOX_HEIGHT = 35;
    private static final long BOSS_ATTACK_DELAY = 1000;

    public Boss(Position startPosition, int health, int damage) {
        super(startPosition, health, damage, BOSS_HITBOX_WIDTH, BOSS_HITBOX_HEIGHT, BOSS_ATTACK_DELAY);
    }

    @Override
    public String toStringImg() {
        return "Boss " + switch (facing){
            case LEFT, DOWN, UP -> "left";
            case RIGHT -> "right";
            case null -> "";
        } + (attacking ? " attack end" : "");
    }
}


