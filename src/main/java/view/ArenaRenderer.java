package view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.entities.Entity;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import view.entities.TreeRenderer;
import view.entities.WallRenderer;

import java.io.IOException;

public class ArenaRenderer {
    public void render(Arena arena, TextGraphics graphics) throws IOException {
        WallRenderer wr = new WallRenderer();
        TreeRenderer tr = new TreeRenderer();

       // graphics.setBackgroundColor(arena.getBackgroundColor());
        //graphics.fillRectangle(new TerminalPosition(0, 0), graphics.getSize(), ' ');

        for(Object object : arena.getObjectList()){
            System.out.println("estou a imprimir objetos");
            if(object.getClass() == Wall.class){
                wr.render((Wall)object, graphics);
                System.out.println("parede");
            }
            else if(object.getClass() == Tree.class){
                tr.render((Tree)object, graphics);
            }
        }
    }
}
