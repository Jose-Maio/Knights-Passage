package model.entities.characters;

import model.Direction;
import model.Position;
import model.entities.Entity;

import java.awt.*;

public interface Character extends Entity , Damageable, Drawable{
    void move(Direction direction);
    Direction getFacing();
    int getHealth();
    int getMaxHealth();
    Rectangle getAttackRange();

    default Position nextPos(Direction direction) {
        Position position = getPosition();
        return switch (direction) {
            case UP -> new Position(position.getX(), position.getY() - 1);
            case DOWN -> new Position(position.getX(), position.getY() + 1);
            case LEFT -> new Position(position.getX() - 1, position.getY());
            case RIGHT -> new Position(position.getX() + 1, position.getY());
            case null -> position;
        };
    }

}