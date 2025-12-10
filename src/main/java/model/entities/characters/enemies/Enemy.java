package model.entities.characters.enemies;

import model.Direction;
import model.Position;
import model.entities.characters.Character;

import java.awt.*;

import static java.lang.Math.abs;

public abstract class Enemy implements Character {
    private Position position;
    private Direction facing;
    private int health;
    private int damage;
    private Rectangle hitbox;
    private final Rectangle vision;
    private boolean attacking = false;

    public Enemy(Position startPosition, int health, int damage){
        this.position = startPosition;
        this.health = health;
        this.damage = damage;
        this.facing = Direction.RIGHT; // default direction
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        this.vision = new Rectangle(position.getX() - 50, position.getY() - 50, 100, 100 );
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        this.vision.setBounds(position.getX() - 50, position.getY() - 50, 100, 100);
    }

    @Override
    public void move(Direction direction) {
        this.facing = direction;
        this.position = nextPos(direction);
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        this.vision.setBounds(position.getX() - 50, position.getY() - 50, 100, 100);
    }

    public Position nextPos(Direction direction) {

        return switch (direction) {
            case UP -> new Position(position.getX(), position.getY() - 1);
            case DOWN -> new Position(position.getX(), position.getY() + 1);
            case LEFT -> new Position(position.getX() - 1, position.getY());
            case RIGHT -> new Position(position.getX() + 1, position.getY());
        };
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

    public int getDamage() {
        return damage;
    }

    public void setAttacking(boolean value){
        this.attacking = value;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public Rectangle getVision() {
        return vision;
    }

    @Override
    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    @Override
    public abstract String toStringImg();
}
