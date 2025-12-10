package model.entities.objects;

import model.Position;

public class SmallWallH extends Object{


    public SmallWallH(Position position){
        super(position);
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
