package model.entities.objects;

import model.Position;
import model.entities.Entity;


import java.awt.*;

public abstract class Object implements Entity {
    private final Position position;
    private final Rectangle hitbox;

    public abstract boolean isSolid();

    public Object(Position position){
        this.position = position;
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Rectangle getHitbox() {
        return hitbox;
    }
}
