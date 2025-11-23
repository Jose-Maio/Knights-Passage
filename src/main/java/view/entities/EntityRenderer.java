package view.entities;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.entities.Entity;

public interface EntityRenderer {
    public default void render(Entity entity, TextGraphics graphics){}
}
