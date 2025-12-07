package model.entities.objects;

import model.Position;

import java.awt.*;

public class Tree extends Object{

    public Tree(Position position){
        super(position);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
