package model.entities.objects;

import model.Position;

import java.awt.*;

public class BigWallV extends Object{


    public BigWallV(Position position){
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 8, 51);
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
