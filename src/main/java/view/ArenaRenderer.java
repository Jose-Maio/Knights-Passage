package view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import gui.Gui;
import gui.LanternaGui;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import view.entities.TreeRenderer;
import view.entities.WallRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ArenaRenderer {

    private BufferedImage arenaBuffer = null;

    public void render(Arena arena, Gui gui) throws IOException {
        if (arenaBuffer == null) {
            arenaBuffer = new BufferedImage(gui.getWidth(), gui.getHeight(), BufferedImage.TYPE_INT_ARGB);
            renderArenaToBuffer(arena, gui, arenaBuffer);
        }

        gui.drawBuffer(arenaBuffer);
    }

    private void renderArenaToBuffer(Arena arena, Gui gui, BufferedImage buffer) throws IOException {
        WallRenderer wr = new WallRenderer();
        TreeRenderer tr = new TreeRenderer();

        gui.drawImageToBuffer(arena.getBackgroundImg(), 0, 0, buffer);

        for (Object obj : arena.getObjectList()) {
            if (obj instanceof Wall) {
                wr.renderToBuffer((Wall) obj, buffer, gui);
                drawHitboxOutline(obj.getHitbox(), Color.RED, buffer);

            } else if (obj instanceof Tree) {
                tr.renderToBuffer((Tree) obj, buffer, gui);
                drawHitboxOutline(obj.getHitbox(), Color.RED, buffer);
            }
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
