package view.entities.objects;


import gui.Gui;
import model.entities.objects.Wall;
import view.entities.EntityRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class WallRenderer implements EntityRenderer<Wall> {

    private final String img;

    public WallRenderer() {
        this.img = "sprites/wall.png";
    }

    public void render(Wall wall, Gui gui) throws IOException {
        gui.drawImage(img, wall.getPosition());

    }
    public void renderToBuffer(Wall wall, BufferedImage buffer, Gui gui) throws IOException {
        gui.drawImageToBuffer(img,
                wall.getPosition().getX(),
                wall.getPosition().getY(),
                buffer);
    }
}
