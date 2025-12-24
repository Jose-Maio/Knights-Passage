package model.entities.objects;

import model.Position;

public class SmallWallV extends Object {

    public SmallWallV(Position position) {
        super(position, 8, 15);
    }

    @Override
    public String toStringImg() {
        return "SmallWallV";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
