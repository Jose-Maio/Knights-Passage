package model.entities.objects;

import model.Position;

public class Key implements Object{
    private final Position position;

    Key(Position position){
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
