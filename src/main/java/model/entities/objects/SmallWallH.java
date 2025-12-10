package model.entities.objects;

import model.Position;

import java.awt.*;

public class SmallWallH extends Object{


    public SmallWallH(Position position){
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 15, 8);
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
