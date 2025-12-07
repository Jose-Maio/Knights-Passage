package view.entities.objects;

import gui.Gui;
import model.entities.objects.Key;
import view.entities.EntityRenderer;

import java.io.IOException;


public class KeyRenderer implements EntityRenderer<Key> {

    private final String img;

    public KeyRenderer() {
        this.img = "sprites/Key.png";
    }

    public void render(Key key, Gui gui) throws IOException {
        if (!key.isPicked()) {
            gui.drawImage(img, key.getPosition());
        }

    }
}
