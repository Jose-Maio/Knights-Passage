package view.entities;

import gui.LanternaGui;
import model.entities.objects.Tree;
import java.io.IOException;


public class TreeRenderer implements EntityRenderer<Tree,LanternaGui> {

    private final String img;

    public TreeRenderer() throws IOException {
        this.img = "sprites/Tree.png";
    }

    public void render(Tree tree, LanternaGui gui) throws IOException {
        gui.drawImage(img, tree.getPosition());
    }
}
