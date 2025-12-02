package model.entities.characters;

import model.Direction;
import model.Position;

import java.awt.*;

public class Player implements Character, Damageable {

    private Position position;
    private int health;
    private final int attackPower;
    private Direction facing;
    private boolean hasKey;
    private final Rectangle hitbox;

    public Player(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
        this.facing = Direction.RIGHT; // default direction
        this.hasKey = false;
        this.position = new Position(0,0);
        this.hitbox = new Rectangle(position.getX(), position.getY(), 16, 16);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void move(Direction direction) {
        this.position = nextPos(direction);
        this.facing = direction;
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

    public int getAttackPower() {
        return attackPower;
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
    public Position nextPos(Direction direction) {

        switch(facing){
            case UP:
                return new Position(position.getX(), position.getY() + 1);
            case DOWN:
                return new Position(position.getX(), position.getY() - 1);
            case LEFT:
                return new Position(position.getX() + 1, position.getY());
            case RIGHT:
                return new Position(position.getX() - 1, position.getY());
        }
        return null;
    }

}