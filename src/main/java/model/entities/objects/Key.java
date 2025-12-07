package model.entities.objects;

import model.Position;


public class Key extends Object{
    private boolean picked;

    @Override
    public boolean isSolid() {
        return false;
    }

    public Key(Position position) {
        super(position);
        this.picked = false;
    }

    public boolean isPicked() {
        return picked;
    }

    public void pick() {
        this.picked = true;
    }
}