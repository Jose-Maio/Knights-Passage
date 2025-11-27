package view.entities;


import gui.LanternaGui;
import model.entities.characters.Player;
import java.io.IOException;


public class PlayerRenderer implements EntityRenderer<Player,LanternaGui> {

    private final String img;

    public PlayerRenderer() throws IOException {
        this.img = "sprites/Knight right.png";
    }

    public void render(Player player, LanternaGui gui) throws IOException {
        gui.drawImage(img, player.getPosition());
    }
}
