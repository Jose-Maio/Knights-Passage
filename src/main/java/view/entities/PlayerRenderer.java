package view.entities;


import gui.Gui;
import model.entities.characters.Player;
import java.io.IOException;


public class PlayerRenderer implements EntityRenderer<Player> {

    private final String img;

    public PlayerRenderer() {
        this.img = "sprites/Knight right.png";
    }

    public void render(Player player, Gui gui) throws IOException {
        gui.drawImage(img, player.getPosition());
    }
}
