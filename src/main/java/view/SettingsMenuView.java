package view;

import gui.Gui;
import model.game.menu.SettingsMenu;

import java.io.IOException;


public class SettingsMenuView {
    private final Gui gui;

    public SettingsMenuView(Gui gui)  {
        this.gui = gui;
    }

    public Gui getGui() {
        return gui;
    }

    public void render(SettingsMenu settingsMenu) throws IOException {

        gui.refresh();
    }
}