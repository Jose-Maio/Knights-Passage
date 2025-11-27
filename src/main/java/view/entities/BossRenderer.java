package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.Boss;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BossRenderer implements EntityRenderer<Boss, LanternaGui>{

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/Boss right.png")
            )
    );

    public BossRenderer() throws IOException {
    }

    public void render(Boss boss, LanternaGui gui) {
        gui.drawImage(sprite, boss.getPosition());
    }
}
