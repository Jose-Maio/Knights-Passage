package model.entities.characters;

import model.Direction;
import model.Position;

import java.awt.*;

public class Player implements Character, Damageable {

    private Position position;
    private int health;
    private int maxHealth;
    private final int attackPower;
    private Direction facing;
    private boolean hasKey;
    private boolean attacking = false;
    private Rectangle hitbox;
    public long lastAttack = 0;
    public long attackDelay = 200;

    public Player(int health, int attackPower) {
        this.maxHealth = health;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.facing = Direction.RIGHT; // default direction
        this.hasKey = false;
        this.position = new Position(0,144);
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

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean value) {
        this.attacking = value;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
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
        return "Knight " + switch (facing){
            case LEFT -> "left";
            case RIGHT -> "right";
            case DOWN -> "front";
            case UP -> "back";
            case null -> "front";
        } + (attacking ? " attack" : "");
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean canAttack() {
        long now = System.currentTimeMillis();

        return now - lastAttack >= attackDelay;
    }

    public void attack(Character character){
        lastAttack =  System.currentTimeMillis();
        character.takeDamage(attackPower);

    }


}