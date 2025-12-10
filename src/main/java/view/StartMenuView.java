package view;

import gui.Gui;
import model.game.menu.StartMenu;

import java.io.IOException;


public class StartMenuView {
    private final Gui gui;

    public StartMenuView(Gui gui)  {
        this.gui = gui;
    }

    public Gui getGui() {
        return gui;
    }

    public void render(StartMenu startMenu) throws IOException {

        gui.refresh();
    }
}
