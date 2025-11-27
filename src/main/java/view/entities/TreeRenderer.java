package view.entities;

import gui.LanternaGui;
import model.entities.objects.Tree;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TreeRenderer implements EntityRenderer<Tree,LanternaGui> {

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/Tree.png")
            )
    );

    public TreeRenderer() throws IOException {
    }

    public void render(Tree tree, LanternaGui gui) {
        gui.drawImage(sprite, tree.getPosition());
    }
}
