package model.entities.objects;

import model.Position;

import java.awt.*;


public class Key extends Object{
    private boolean picked;

    @Override
    public boolean isSolid() {
        return false;
    }

    public Key(Position position) {
        super(position);
        this.picked = false;
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
    }

    @Override
    public String toStringImg() {
        return "Key";
    }

    public boolean isPicked() {
        return picked;
    }

    public void pick() {
        this.picked = true;
    }
}