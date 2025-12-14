package model.entities.objects;

import model.Position;
import model.entities.Entity;
import model.entities.characters.Drawable;

import java.awt.*;

public abstract class Object implements Entity, Drawable {
    protected final static int HITBOX_OFFSET = 2;

    private final Position position;
    protected Rectangle hitbox;

    public abstract boolean isSolid();

    public Object(Position position, int hitboxWidth, int hitboxHeight){
        this.position = position;
        this.hitbox = new Rectangle(position.getX() + HITBOX_OFFSET, position.getY() + HITBOX_OFFSET, hitboxWidth, hitboxHeight);
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
