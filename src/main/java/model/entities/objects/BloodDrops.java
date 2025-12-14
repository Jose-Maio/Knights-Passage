package model.entities.objects;

import model.Position;


public class BloodDrops extends Object {

    @Override
    public boolean isSolid() {
        return false;
    }

    public BloodDrops(Position position) {
        super(position, 12, 12);
    }

    @Override
    public String toStringImg() {
        return "blood_splatter";
    }
}
