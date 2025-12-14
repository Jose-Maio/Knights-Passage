package view.entities;

import gui.Gui;
import model.entities.Entity;
import model.entities.characters.Drawable;


import java.io.IOException;

public interface EntityRenderer<T extends Drawable> {
    String getImgPath(T drawable);
    void render(T drawable ,Gui gui) throws IOException;

}
