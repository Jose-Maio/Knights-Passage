package controller.menu;


import controller.Controller;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.SettingsMenu;
import model.game.config.Difficulty;


public class SettingsMenuController extends AbstractMenuController<Difficulty, SettingsMenu> implements Controller<Difficulty> {


    public SettingsMenuController(SettingsMenu menu, Gui gui){
        super(menu,gui);
    }


    public Difficulty update(){
        Button selectedButton = menu.getSelectedButton();
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