package model.entities.objects;

import model.Position;

import java.awt.*;

public class SmallWallV extends Object{


    public SmallWallV(Position position){
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 8, 15);
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
