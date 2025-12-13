package view;

import gui.Gui;
import model.Button;
import model.Position;
import model.game.menu.Menu;

import java.io.IOException;

public class MenuView {

    private final Gui gui;

    public MenuView(Gui gui){
        this.gui = gui;
    }

    public void render(Menu menu) throws IOException {
        gui.drawImage(menu.getBackgroundImg(), new Position(0,0));
        ButtonRenderer br = new ButtonRenderer();
        for(Button button : menu.getButtons()){
            br.render(button,gui);
        }
        gui.refresh();

    }
}
