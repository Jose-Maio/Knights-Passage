package view.entities.enemies;

import gui.Gui;
import model.entities.characters.enemies.DungeonEnemy;
import view.entities.EntityRenderer;

import java.io.IOException;


public class DungeonEnemyRenderer implements EntityRenderer<DungeonEnemy> {

    private final String img;

    public DungeonEnemyRenderer() {
        this.img = "sprites/DungeonEnemy right.png";
    }

    public void render(DungeonEnemy dungeonEnemy, Gui gui) throws IOException {
        gui.drawImage(img, dungeonEnemy.getPosition());
    }
}