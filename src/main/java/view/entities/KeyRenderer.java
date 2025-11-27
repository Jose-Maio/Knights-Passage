package view.entities;

import gui.LanternaGui;
import model.entities.objects.Key;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class KeyRenderer implements EntityRenderer<Key,LanternaGui> {

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/Key.png")
            )
    );

    public KeyRenderer() throws IOException {
    }

    public void render(Key key, LanternaGui gui) {
        gui.drawImage(sprite, key.getPosition());
    }
}
