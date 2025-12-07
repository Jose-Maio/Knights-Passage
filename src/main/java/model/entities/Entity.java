package model.entities;

import model.Position;

import java.awt.*;

public interface Entity {
    public Position getPosition();
    public Rectangle getHitbox();
}
