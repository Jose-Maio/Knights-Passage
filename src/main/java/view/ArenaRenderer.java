package view;

import gui.Gui;
import model.entities.objects.Key;
import model.entities.objects.Object;
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
        if(arena.getKey() != null )objectRenderer.render(arena.getKey(), gui);
    }

    private void renderArenaToBuffer(Arena arena, Gui gui, BufferedImage buffer) throws IOException {
        ObjectRenderer objectRenderer= new ObjectRenderer();

        gui.drawImageToBuffer(arena.getBackgroundImg(), 0, 0, buffer);

        for (Object obj : arena.getObjectList()) {
            if(obj instanceof Key) continue;
            else objectRenderer.renderToBuffer(obj, buffer , gui);
        }
    }

    public void resetArennaBuffer(){
        this.arenaBuffer = null;
    }






}
