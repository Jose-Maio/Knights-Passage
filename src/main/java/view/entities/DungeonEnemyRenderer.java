package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.DungeonEnemy;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class DungeonEnemyRenderer implements EntityRenderer<DungeonEnemy, LanternaGui>{

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/DungeonEnemy right.png")
            )
    );

    public DungeonEnemyRenderer() throws IOException {
    }

    public void render(DungeonEnemy dungeonEnemy, LanternaGui gui) {
        gui.drawImage(sprite, dungeonEnemy.getPosition());
    }
}