package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.CastleEnemy;
import java.io.IOException;


public class CastleEnemyRenderer implements EntityRenderer<CastleEnemy, LanternaGui>{

    private final String img;

    public CastleEnemyRenderer() throws IOException {
        this.img = "sprites/CastleEnemy right.png";
    }

    public void render(CastleEnemy castleEnemy, LanternaGui gui) throws IOException {
        gui.drawImage(img, castleEnemy.getPosition());
    }
}
