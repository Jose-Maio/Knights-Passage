package model.entities.objects;

import model.Position;


public class BigWallH extends Object{


    public BigWallH(Position position){
        super(position, 51, 8);

    }

    @Override
    public String toStringImg() {
        return "BigWallH";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
