package model.entities.characters;

import model.Direction;
import model.Position;

import java.awt.*;

public class Player implements Character, Damageable {

    private static final int HITBOX_WIDTH = 12;
    private static final int HITBOX_HEIGHT = 12;
    private static final int HITBOX_OFFSET = 2;

    private Position position;
    private int health;
    private final int maxHealth;
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

        this.hitbox = new Rectangle(position.getX() + HITBOX_OFFSET, position.getY() + HITBOX_OFFSET, HITBOX_WIDTH, HITBOX_HEIGHT);
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
        this.hitbox.setBounds(position.getX() + HITBOX_OFFSET, position.getY() + HITBOX_OFFSET, HITBOX_WIDTH, HITBOX_HEIGHT);
    }

    @Override
    public void move(Direction direction) {
        setFacing(direction);
        setPosition(nextPos(direction));
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