package controller.menu;


import controller.Controller;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.ControlsMenu;
import model.game.menu.StartMenu;


public class ControlsMenuController extends AbstractMenuController<Void, ControlsMenu> implements Controller<Void> {

    public ControlsMenuController(ControlsMenu menu, Gui gui){
        super(menu,gui);
    }

    @Override
    public Void update() throws Exception {
        Button selectedButton = menu.getSelectedButton();
        if(selectedButton.getOption() == Options.BACK){
            StartMenuController startMenuController = new StartMenuController(new StartMenu(),gui);
            startMenuController.start();
        }
        return null;
    }


}
