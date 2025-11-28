package view.entities;

import gui.Gui;
import model.entities.objects.Tree;
import java.io.IOException;


public class TreeRenderer implements EntityRenderer<Tree> {

    private final String img;

    public TreeRenderer() {
        this.img = "sprites/Tree.png";
    }

    public void render(Tree tree, Gui gui) throws IOException {
        gui.drawImage(img, tree.getPosition());
    }
}
