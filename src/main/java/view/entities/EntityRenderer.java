package view.entities;

import gui.Gui;
import model.entities.Entity;


import java.io.IOException;

public abstract class EntityRenderer<T extends Entity> {
    public abstract String getImgPath(T Entity);
    public abstract void render(T entity,Gui gui) throws IOException;

}
