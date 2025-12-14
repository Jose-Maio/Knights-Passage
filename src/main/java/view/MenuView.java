package view;

import gui.Gui;
import model.Button;
import model.Position;
import model.game.menu.Menu;

import java.io.IOException;

public class MenuView {

    private final Gui gui;
    ButtonRenderer buttonRenderer;

    public MenuView(Gui gui){
        this.gui = gui;
        this.buttonRenderer = new ButtonRenderer();
    }

    public void render(Menu menu) throws IOException {
        gui.drawImage(menu.getBackgroundImg(), new Position(0,0));

        for(Button button : menu.getButtons()){
            buttonRenderer.render(button,gui);
        }
        gui.refresh();

    }
}
