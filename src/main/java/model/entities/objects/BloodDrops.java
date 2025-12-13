package model.entities.objects;

import model.Position;

import java.awt.*;

public class BloodDrops extends Object {

    @Override
    public boolean isSolid() {
        return false;
    }

    public BloodDrops(Position position) {
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);

    }

    @Override
    public String toStringImg() {
        return "blood_splatter";
    }
}
