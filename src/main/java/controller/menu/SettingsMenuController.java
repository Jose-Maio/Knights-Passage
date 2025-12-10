package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import controller.Controller;
import gui.Gui;
import model.Options;
import model.game.menu.SettingsMenu;
import model.game.config.Difficulty;
import view.SettingsMenuView;

import java.io.IOException;


public class SettingsMenuController implements Controller<Difficulty> {
    private final SettingsMenu settingsMenu;
    private final SettingsMenuView settingsMenuView;
    private final Gui gui;

    public SettingsMenuController(SettingsMenu settingsMenu, Gui gui) throws Exception {
        this.settingsMenu = settingsMenu;
        this.gui = gui;
        this.settingsMenuView = new SettingsMenuView(gui);
    }

    public Difficulty start() throws Exception {

        while(!settingsMenu.isSelected()){

            settingsMenuView.render(settingsMenu);

            handleInput();


        }
        return update();
    }

    public void handleInput() throws IOException {
        KeyStroke keystroke = gui.step();
        if(keystroke == null) return;

        switch (keystroke.getKeyType()) {
            case ArrowUp -> settingsMenu.previousOption();
            case ArrowDown -> settingsMenu.nextOption();
            case Enter -> settingsMenu.setSelected();
        };
    }

    public Difficulty update(){
        if(settingsMenu.getCurrOption() == Options.EASY_MODE){
            return Difficulty.EASY;
        }
        else if(settingsMenu.getCurrOption() == Options.MEDIUM_MODE){
            return Difficulty.MEDIUM;

        }
        else if (settingsMenu.getCurrOption() == Options.HARD_MODE){
            return Difficulty.HARD;

        }
        return Difficulty.MEDIUM;
    }
}