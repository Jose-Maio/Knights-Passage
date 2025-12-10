package model.entities.characters.enemies;


import model.Position;

import java.awt.*;

public class Boss extends Enemy {
    public Boss(Position startPosition, int health, int damage) {
        super(startPosition, health, damage);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 39, 35);
    }

    @Override
    public String toStringImg() {
        System.out.println("boss is being drawn" + facing + attacking);;
        return "Boss " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN, UP -> "left";
            case null -> "";
        } + (attacking ? " attack end" : "");
    }
}


