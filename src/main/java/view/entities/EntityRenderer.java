package view.entities;

import gui.Gui;
import model.entities.Entity;

public interface EntityRenderer {
    public default void render(Entity entity, Gui gui){}
}
