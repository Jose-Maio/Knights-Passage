package model.entities.characters;

import model.Direction;
import model.Position;
import model.game.config.GameConfiguration;

public class Player implements Character, Damageable {

    private Position position;
    private int health;
    private int attackPower;
    private Direction facing;
    private boolean hasKey;

    public Player(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
        this.facing = Direction.RIGHT; // default direction
        this.hasKey = false;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public int getAttackpower() {
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
}