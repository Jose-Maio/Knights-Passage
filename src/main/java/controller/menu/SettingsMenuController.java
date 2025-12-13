package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import controller.Controller;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.SettingsMenu;
import model.game.config.Difficulty;
import view.MenuView;

import java.io.IOException;


public class SettingsMenuController implements Controller<Difficulty> {
    private final SettingsMenu settingsMenu;
    private final MenuView menuView;
    private final Gui gui;

    public SettingsMenuController(SettingsMenu settingsMenu, Gui gui){
        this.settingsMenu = settingsMenu;
        this.gui = gui;
        this.menuView = new MenuView(gui);
    }

    public Difficulty start() throws Exception {

        while(!settingsMenu.isSelected()){

            menuView.render(settingsMenu);

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
            case Enter -> settingsMenu.setSelected(true);
        };
    }

    public Difficulty update(){
        Button selectedButton = settingsMenu.getSelectedButton();
        if(selectedButton.getOption() == Options.EASY_MODE){
            return Difficulty.EASY;
        }
        else if(selectedButton.getOption() == Options.MEDIUM_MODE){
            return Difficulty.MEDIUM;

        }
        else if (selectedButton.getOption() == Options.HARD_MODE){
            return Difficulty.HARD;

        }
        return Difficulty.MEDIUM;
    }
}