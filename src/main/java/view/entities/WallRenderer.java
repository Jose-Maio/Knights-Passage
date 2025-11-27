package view.entities;


import gui.LanternaGui;
import model.entities.objects.Wall;
import java.io.IOException;


public class WallRenderer implements EntityRenderer<Wall,LanternaGui> {

    private final String img;

    public WallRenderer() throws IOException {
        this.img = "sprites/wall.png";
    }

    public void render(Wall wall, LanternaGui gui) throws IOException {
        gui.drawImage(img, wall.getPosition());

    }
}
