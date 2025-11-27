package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.ForestEnemy;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ForestEnemyRenderer implements EntityRenderer<ForestEnemy, LanternaGui>{

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/ForestEnemy right.png")
            )
    );

    public ForestEnemyRenderer() throws IOException {
    }

    public void render(ForestEnemy forestEnemy, LanternaGui gui) {
        gui.drawImage(sprite, forestEnemy.getPosition());
    }
}
