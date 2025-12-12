package view.entities;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.Gui;
import model.entities.characters.Character;

import java.awt.*;
import java.io.IOException;

public class CharacterRenderer extends EntityRenderer<Character> {


    @Override
    public String getImgPath(Character character) {
        return "sprites/characters/" + character.toStringImg() + ".png";
    }

    @Override
    public void render(Character character, Gui gui) throws IOException {
        gui.drawImage(getImgPath(character), character.getPosition());}
        /*drawHitboxOutline(gui.getGraphics(), character.getHitbox().x, character.getHitbox().y,
                character.getHitbox().width, character.getHitbox().height);

    }


    private void drawHitboxOutline(TextGraphics g, int x, int y, int w, int h) {

        g.setForegroundColor(TextColor.ANSI.RED);

        // Top border
        for (int i = 1; i < w - 1; i++)
            g.putString(x + i, y, "-");

        // Bottom border
        for (int i = 1; i < w - 1; i++)
            g.putString(x + i, y + h - 1, "-");

        // Left & Right borders
        for (int i = 1; i < h - 1; i++) {
            g.putString(x, y + i, "|");
            g.putString(x + w - 1, y + i, "|");
        }

        // Corners
        g.putString(x, y, "+");                       // top-left
        g.putString(x + w - 1, y, "+");               // top-right
        g.putString(x, y + h - 1, "+");               // bottom-left
        g.putString(x + w - 1, y + h - 1, "+");       // bottom-right
    }*/
}
