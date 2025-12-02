package model.entities.characters.enemies;

import model.Direction;
import model.Position;
import model.entities.characters.Character;
import org.w3c.dom.css.Rect;

import java.awt.*;

public abstract class Enemy implements Character {
    private Position position;
    private Direction facing;
    private int health;
    private int damage;
    private final Rectangle hitbox;
    private final Rectangle vision;

    public Enemy(Position startPosition, int health, int damage){
        this.position = startPosition;
        this.health = health;
        this.damage = damage;
        this.facing = Direction.RIGHT; // default direction
        this.hitbox = new Rectangle(position.getX(), position.getY(), 16, 16);
        this.vision = new Rectangle(position.getX(), position.getY(), 50, 50);
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

    public void update(){}

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
}
