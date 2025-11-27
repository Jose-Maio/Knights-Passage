package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.CastleEnemy;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CastleEnemyRenderer implements EntityRenderer<CastleEnemy, LanternaGui>{

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/CastleEnemy right.png")
            )
    );

    public CastleEnemyRenderer() throws IOException {
    }

    public void render(CastleEnemy castleEnemy, LanternaGui gui) {
        gui.drawImage(sprite, castleEnemy.getPosition());
    }
}
