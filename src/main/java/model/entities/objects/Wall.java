package model.entities.objects;

import model.Position;

public class Wall implements Object{
    private final Position position;

    Wall(Position position){
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
