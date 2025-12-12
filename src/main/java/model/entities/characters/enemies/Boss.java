package model.entities.characters.enemies;


import model.Position;

import java.awt.*;

public class Boss extends Enemy {
    public Boss(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 39, 35);
        this.attackDelay = 1000;
    }

    @Override
    public String toStringImg() {
        return "Boss " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN, UP -> "left";
            case null -> "";
        } + (attacking ? " attack end" : "");
    }
}


