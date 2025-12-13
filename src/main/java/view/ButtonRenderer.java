package view;

import gui.Gui;
import model.Button;

import java.io.IOException;


public class ButtonRenderer {
    public String getImgPath(Button button) {
        return "sprites/menu/buttons/" + button.toStringImg() + ".png";
    }

    public void render(Button button, Gui gui) throws IOException {
        gui.drawImage(getImgPath(button), button.getPosition());
    }

}
