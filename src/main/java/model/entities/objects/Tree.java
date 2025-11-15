package model.entities.objects;

import model.Position;

public class Tree implements Object{
    private final Position position;

    Tree(Position position){
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
