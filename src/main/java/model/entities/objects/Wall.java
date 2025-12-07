package model.entities.objects;

import model.Position;

public class Wall extends Object{


    public Wall(Position position){
        super(position);
    }

    @Override
    public String toStringImg() {
        return "Wall";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
