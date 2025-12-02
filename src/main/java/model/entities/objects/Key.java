package model.entities.objects;

import model.Position;


public class Key extends Object{
    @Override
    public boolean isSolid() {
        return false;
    }
    public Key(Position position) {
        super(position);
    }

}