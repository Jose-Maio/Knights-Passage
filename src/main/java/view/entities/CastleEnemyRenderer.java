package view.entities;

import gui.Gui;
import model.entities.characters.enemies.CastleEnemy;
import java.io.IOException;


public class CastleEnemyRenderer implements EntityRenderer<CastleEnemy>{

    private final String img;

    public CastleEnemyRenderer() {
        this.img = "sprites/CastleEnemy right.png";
    }

    public void render(CastleEnemy castleEnemy, Gui gui) throws IOException {
        gui.drawImage(img, castleEnemy.getPosition());
    }
}
