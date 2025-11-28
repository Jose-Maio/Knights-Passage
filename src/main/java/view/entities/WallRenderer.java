package view.entities;


import gui.Gui;
import model.entities.objects.Wall;
import java.io.IOException;


public class WallRenderer implements EntityRenderer<Wall> {

    private final String img;

    public WallRenderer() {
        this.img = "sprites/wall.png";
    }

    public void render(Wall wall, Gui gui) throws IOException {
        gui.drawImage(img, wall.getPosition());

    }
}
