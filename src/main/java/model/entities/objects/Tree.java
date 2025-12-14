package model.entities.objects;

import model.Position;

public class Tree extends Object{

    public Tree(Position position){
        super(position, 16, 21);
    }

    @Override
    public String toStringImg() {
        return "Tree";
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
