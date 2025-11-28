package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.ForestEnemy;
import java.io.IOException;


public class ForestEnemyRenderer implements EntityRenderer<ForestEnemy, LanternaGui>{

    private final String img;

    public ForestEnemyRenderer() throws IOException {
        this.img = "sprites/ForestEnemy front.png";
    }

    public void render(ForestEnemy forestEnemy, LanternaGui gui) throws IOException {
        gui.drawImage(img, forestEnemy.getPosition());
    }
}
