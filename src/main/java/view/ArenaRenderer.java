package view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.entities.Entity;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import view.entities.TreeRenderer;
import view.entities.WallRenderer;

public class ArenaRenderer {
    public void render(Arena arena, TextGraphics graphics){
        WallRenderer wr = new WallRenderer();
        TreeRenderer tr = new TreeRenderer();

       // graphics.setBackgroundColor(arena.getBackgroundColor());
        //graphics.fillRectangle(new TerminalPosition(0, 0), graphics.getSize(), ' ');

        for(Entity object : arena.getObjectList()){
            if(object.getClass() == Wall.class){
                wr.render(object, graphics);
            }
            else if(object.getClass() == Tree.class){
                tr.render(object, graphics);
            }
        }
    }
}
