package view.entities;

import gui.Gui;
import model.entities.Entity;


import java.io.IOException;

public interface EntityRenderer<T extends Entity> {
    void render(T entity,Gui gui) throws IOException;

}
