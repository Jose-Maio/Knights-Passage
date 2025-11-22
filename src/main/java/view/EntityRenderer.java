package view;

import model.entities.Entity;

public interface EntityRenderer {
    public default void render(Entity entity, Screen screen){}
}
