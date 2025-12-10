package model.entities.objects;

import model.Position;
import model.entities.Entity;


import java.awt.*;

public abstract class Object implements Entity {
    private final Position position;
    protected Rectangle hitbox;

    public abstract boolean isSolid();

    public Object(Position position){
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Rectangle getHitbox() {
        return hitbox;
    }

    @Override
    public abstract String toStringImg();
}
