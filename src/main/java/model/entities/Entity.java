package model.entities;

import model.Position;

import java.awt.*;

public interface Entity {
    Position getPosition();
    Rectangle getHitbox();

}
