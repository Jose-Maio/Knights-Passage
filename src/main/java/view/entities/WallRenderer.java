package view.entities;


import gui.LanternaGui;
import model.entities.objects.Wall;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class WallRenderer implements EntityRenderer<Wall,LanternaGui> {

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/wall.png")
            )
    );

    public WallRenderer() throws IOException {
    }

    public void render(Wall wall, LanternaGui gui) {
        gui.drawImage(sprite, wall.getPosition());

    }
}
