package view.entities;

import gui.Gui;
import model.entities.Entity;


import java.io.IOException;

public interface EntityRenderer<T extends Entity, G extends Gui> {
    void render(T entity,G gui) throws IOException;

}
