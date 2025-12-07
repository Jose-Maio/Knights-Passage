package model.entities.objects;

import model.Position;

public class Wall extends Object{


    public Wall(Position position){
        super(position);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
