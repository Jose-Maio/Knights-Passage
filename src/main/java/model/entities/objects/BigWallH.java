package model.entities.objects;

import model.Position;

import java.awt.*;

public class BigWallH extends Object{


    public BigWallH(Position position){
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 51, 8);
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
