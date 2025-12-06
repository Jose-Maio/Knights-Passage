package view.entities.enemies;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import gui.Gui;
import model.entities.characters.enemies.ForestEnemy;
import view.entities.EntityRenderer;

import java.awt.*;
import java.io.IOException;


public class ForestEnemyRenderer implements EntityRenderer<ForestEnemy> {

    private final String img;

    public ForestEnemyRenderer() throws IOException {
        this.img = "sprites/ForestEnemy front.png";
    }

    public void render(ForestEnemy forestEnemy, Gui gui) throws IOException {
        gui.drawImage(img, forestEnemy.getPosition());

        drawHitboxOutline(forestEnemy.getHitbox(), gui);
    }

    private void drawHitboxOutline(Rectangle hb, Gui gui) {

        TextCharacter px = new TextCharacter(' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.RED);

        int x1 = hb.x;
        int y1 = hb.y;
        int x2 = hb.x + hb.width - 1;
        int y2 = hb.y + hb.height - 1;

        // Top border
        for (int x = x1; x <= x2; x++)
            gui.getScreen().setCharacter(x, y1, px);

        // Bottom border
        for (int x = x1; x <= x2; x++)
            gui.getScreen().setCharacter(x, y2, px);

        // Left border
        for (int y = y1; y <= y2; y++)
            gui.getScreen().setCharacter(x1, y, px);

        // Right border
        for (int y = y1; y <= y2; y++)
            gui.getScreen().setCharacter(x2, y, px);
    }
}
