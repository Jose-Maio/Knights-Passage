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
        this.hitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        this.vision.setBounds(position.getX() - 50, position.getY() - 50, 100, 100);
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

    @Override
    public abstract String toStringImg();
}
