package controller.menu;


import controller.Controller;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.GameOverMenu;
import model.game.menu.StartMenu;


public class GameOverMenuController extends AbstractMenuController<Void, GameOverMenu> implements Controller<Void> {

    public GameOverMenuController(GameOverMenu menu , Gui gui){
        super(menu,gui);
    }


    public Void update() throws Exception {
        Button selectedButton = menu.getSelectedButton();
        if (selectedButton.getOption() == Options.BACK) {
            StartMenuController startMenuController = new StartMenuController(new StartMenu(), gui);
            startMenuController.start();
        } else if (selectedButton.getOption() == Options.EXIT) {
            gui.getScreen().close();

        }
        return null;
    }

};
