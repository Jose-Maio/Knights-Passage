package model.entities.characters;

import model.Direction;
import model.entities.Entity;

public interface Character extends Entity , Damageable{
    void move(Direction direction);
}