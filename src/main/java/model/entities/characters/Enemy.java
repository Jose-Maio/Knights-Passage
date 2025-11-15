package model.entities.characters;

import model.Direction;
import model.Position;

public abstract class Enemy implements Character{
    private Position position;
    private Direction facing;
    private int health;
    private int damage;

    public Enemy(int health, int damage){
        this.health = health;
        this.damage = damage;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void move(Direction direction) {
        this.facing = direction;
        switch(facing){
            case UP:
                this.position.setY(position.getY() - 1);
                break;
            case DOWN:
                this.position.setY(position.getY() + 1);
                break;
            case LEFT:
                this.position.setX(position.getX() - 1);
                break;
            case RIGHT:
                this.position.setX(position.getX() + 1);
                break;
        }
    }

    public void update(){}
}
