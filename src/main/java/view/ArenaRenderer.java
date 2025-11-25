package view;


import gui.LanternaGui;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.entities.objects.Wall;
import model.game.Arena;
import view.entities.TreeRenderer;
import view.entities.WallRenderer;

import java.io.IOException;

public class ArenaRenderer {
    public void render(Arena arena, LanternaGui gui) throws IOException {
        WallRenderer wr = new WallRenderer();
        TreeRenderer tr = new TreeRenderer();


        for(Object object : arena.getObjectList()){
            if(object.getClass() == Wall.class){
                wr.render((Wall)object, gui);
            }
            else if(object.getClass() == Tree.class){
                tr.render((Tree)object, gui);
            }
        }
    }
}
