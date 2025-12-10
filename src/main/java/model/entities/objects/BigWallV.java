package model.entities.objects;

import model.Position;

public class BigWallV extends Object{


    public BigWallV(Position position){
        super(position);
    }

    @Override
    public String toStringImg() {
        return "BigWallV";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
