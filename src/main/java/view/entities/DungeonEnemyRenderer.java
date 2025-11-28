package view.entities;

import gui.LanternaGui;
import model.entities.characters.enemies.DungeonEnemy;
import java.io.IOException;


public class DungeonEnemyRenderer implements EntityRenderer<DungeonEnemy, LanternaGui>{

    private final String img;

    public DungeonEnemyRenderer() throws IOException {
        this.img = "sprites/DungeonEnemy right.png";
    }

    public void render(DungeonEnemy dungeonEnemy, LanternaGui gui) throws IOException {
        gui.drawImage(img, dungeonEnemy.getPosition());
    }
}