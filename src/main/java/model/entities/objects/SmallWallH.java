package model.entities.objects;

import model.Position;

public class SmallWallH extends Object {

    public SmallWallH(Position position) {
        super(position, 15, 8);
    }

    @Override
    public String toStringImg() {
        return "SmallWallH";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
