package view;

import gui.Gui;
import model.entities.objects.Key;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import view.entities.ObjectRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ArenaRenderer {

    private BufferedImage arenaBuffer = null;


    public void render(Arena arena, Gui gui) throws IOException {
        ObjectRenderer objectRenderer= new ObjectRenderer();
        if (arenaBuffer == null) {
            arenaBuffer = new BufferedImage(gui.getWidth(), gui.getHeight(), BufferedImage.TYPE_INT_ARGB);
            renderArenaToBuffer(arena, gui, arenaBuffer);
        }

        gui.drawBuffer(arenaBuffer);
        objectRenderer.render(arena.getKey(), gui);
    }

    private void renderArenaToBuffer(Arena arena, Gui gui, BufferedImage buffer) throws IOException {
        ObjectRenderer objectRenderer= new ObjectRenderer();

        gui.drawImageToBuffer(arena.getBackgroundImg(), 0, 0, buffer);

        for (Object obj : arena.getObjectList()) {
            if(obj instanceof Key) continue;
            else objectRenderer.renderToBuffer(obj, buffer , gui);
        }
    }

    public void drawHitboxOutline(Rectangle hb, Color color, BufferedImage buffer) {
        Graphics2D g = buffer.createGraphics();

        g.setColor(color);
        g.setStroke(new BasicStroke(1)); // 1-pixel thick border

        g.drawRect(hb.x, hb.y, hb.width, hb.height);

        g.dispose();
    }




}
