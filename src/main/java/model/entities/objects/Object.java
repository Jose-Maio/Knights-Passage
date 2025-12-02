package model.entities.objects;

import model.Position;
import model.entities.Entity;
import org.w3c.dom.css.Rect;

import java.awt.*;

public abstract class Object implements Entity {
    private final Position position;
    private final Rectangle hitbox;

    public abstract boolean isSolid();

    public Object(Position position){
        this.position = position;
        this.hitbox = new Rectangle(position.getX(), position.getY(), 16, 16);
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
