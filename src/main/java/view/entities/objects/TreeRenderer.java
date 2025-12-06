package view.entities.objects;

import gui.Gui;
import model.entities.objects.Tree;
import view.entities.EntityRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class TreeRenderer implements EntityRenderer<Tree> {

    private final String img;

    public TreeRenderer() {
        this.img = "sprites/Tree.png";
    }

    public void render(Tree tree, Gui gui) throws IOException {
        gui.drawImage(img, tree.getPosition());
    }

    public void renderToBuffer(Tree tree, BufferedImage buffer, Gui gui) throws IOException {
        gui.drawImageToBuffer(img,
                tree.getPosition().getX(),
                tree.getPosition().getY(),
                buffer);
    }
}
