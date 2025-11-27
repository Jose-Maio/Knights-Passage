package view.entities;

import gui.LanternaGui;
import model.entities.objects.Key;
import java.io.IOException;


public class KeyRenderer implements EntityRenderer<Key,LanternaGui> {

    private final String img;

    public KeyRenderer() throws IOException {
        this.img = "sprites/Key.png";
    }

    public void render(Key key, LanternaGui gui) throws IOException {
        gui.drawImage(img, key.getPosition());
    }
}
