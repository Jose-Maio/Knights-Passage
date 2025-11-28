package view.entities;

import gui.Gui;
import model.entities.characters.enemies.DungeonEnemy;
import java.io.IOException;


public class DungeonEnemyRenderer implements EntityRenderer<DungeonEnemy>{

    private final String img;

    public DungeonEnemyRenderer() {
        this.img = "sprites/DungeonEnemy right.png";
    }

    public void render(DungeonEnemy dungeonEnemy, Gui gui) throws IOException {
        gui.drawImage(img, dungeonEnemy.getPosition());
    }
}