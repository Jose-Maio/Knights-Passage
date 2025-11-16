package model.entities.characters;

import model.Direction;
import model.Position;

public class Player implements Character {

    private Position position;
    private int health;
    private int attack_power;
    private Direction facing;
    private boolean hasKey;

    public Player(Position startPosition, int health, int attack_power) {
        this.position = startPosition;
        this.health = health;
        this.attack_power = attack_power;
        this.facing = Direction.RIGHT; // default direction
        this.hasKey = false;
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

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack_power() {
        return attack_power;
    }

    public Direction getFacing() {
        return facing;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void pickUpKey() {
        this.hasKey = true;
    }

    public void attack() {
    }
}