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
    private boolean attacking = false;
    private Rectangle hitbox;

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
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
    }

    @Override
    public void move(Direction direction) {
        this.position = nextPos(direction);
        this.facing = direction;
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
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

    public Position nextPos(Direction direction) {

        return switch (direction) {
            case UP -> new Position(position.getX(), position.getY() - 1);
            case DOWN -> new Position(position.getX(), position.getY() + 1);
            case LEFT -> new Position(position.getX() - 1, position.getY());
            case RIGHT -> new Position(position.getX() + 1, position.getY());
        };
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    @Override
    public String toStringImg(){
        System.out.println("its calling me");
        return "Knight " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "front";
        } + (attacking ? " attack" : "");
    }
}