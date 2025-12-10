package model.entities.objects;

import model.Position;

import java.awt.*;

public class Tree extends Object{

    public Tree(Position position){
        super(position);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 16, 21);
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
