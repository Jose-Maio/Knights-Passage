package view.entities;


import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import gui.Gui;
import model.entities.characters.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class PlayerRenderer implements EntityRenderer<Player> {

    private final String img;

    public PlayerRenderer() {
        this.img = "sprites/Knight right.png";
    }

    public void render(Player player, Gui gui) throws IOException {
        gui.drawImage(img, player.getPosition());

        drawHitboxOutline(player.getHitbox(), gui);
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
