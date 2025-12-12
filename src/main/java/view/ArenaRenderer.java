package view;

import gui.Gui;
import model.entities.objects.Object;
import model.game.Arena;
import view.entities.ObjectRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ArenaRenderer {

    private BufferedImage arenaBuffer = null;
    ObjectRenderer objectRenderer= new ObjectRenderer();


    public void render(Arena arena, Gui gui) throws IOException {

        if (arenaBuffer == null) {
            arenaBuffer = new BufferedImage(gui.getWidth(), gui.getHeight(), BufferedImage.TYPE_INT_ARGB);
            renderArenaToBuffer(arena, gui, arenaBuffer);
        }

        gui.drawBuffer(arenaBuffer);
        for(Object object : arena.getDynamicObjectList()){
            objectRenderer.render(object,gui);
        }
    }

    private void renderArenaToBuffer(Arena arena, Gui gui, BufferedImage buffer) throws IOException {

        gui.drawImageToBuffer(arena.getBackgroundImg(), 0, 0, buffer);

        for (Object obj : arena.getStaticObjectList()) {
            objectRenderer.renderToBuffer(obj, buffer , gui);
        }
    }

    public void resetArenaBuffer(){
        this.arenaBuffer = null;
    }






}
