package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.Boss;
import java.io.IOException;


public class BossRenderer implements EntityRenderer<Boss, LanternaGui>{

    private final String img ;

    public BossRenderer() throws IOException {
        this.img = "sprites/Boss right.png";
    }

    public void render(Boss boss, LanternaGui gui) throws IOException {
        gui.drawImage(img, boss.getPosition());
    }
}
