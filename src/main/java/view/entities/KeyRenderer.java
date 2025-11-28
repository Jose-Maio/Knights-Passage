package view.entities;

import gui.Gui;
import model.entities.objects.Key;
import java.io.IOException;


public class KeyRenderer implements EntityRenderer<Key> {

    private final String img;

    public KeyRenderer() {
        this.img = "sprites/Key.png";
    }

    public void render(Key key, Gui gui) throws IOException {
        gui.drawImage(img, key.getPosition());
    }
}
