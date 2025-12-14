package model.entities.objects;

import model.Position;

public class Key extends Object{
    private boolean picked;

    @Override
    public boolean isSolid() {
        return false;
    }

    public Key(Position position) {
        super(position, 12, 12);
        this.picked = false;

    }

    @Override
    public String toStringImg() {
        return "Key";
    }

    public void pick() {
        this.picked = true;
    }


}