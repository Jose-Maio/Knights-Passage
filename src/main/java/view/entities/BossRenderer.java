package view.entities;

import gui.Gui;
import model.entities.characters.enemies.Boss;
import java.io.IOException;


public class BossRenderer implements EntityRenderer<Boss>{

    private final String img ;

    public BossRenderer() {
        this.img = "sprites/Boss right.png";
    }

    public void render(Boss boss, Gui gui) throws IOException {
        gui.drawImage(img, boss.getPosition());
    }
}
