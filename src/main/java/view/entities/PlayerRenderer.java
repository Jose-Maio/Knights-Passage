package view.entities;


import gui.LanternaGui;
import model.entities.characters.Player;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerRenderer implements EntityRenderer {

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/Monkey.png")
            )
    );

    public PlayerRenderer() throws IOException {
    }

    public void render(Player player, LanternaGui gui) {
        gui.drawImage(sprite, player.getPosition());
    }
}
