package controller.menu;

import controller.Controller;
import controller.GameController;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.Game;
import model.game.menu.ControlsMenu;
import model.game.menu.StartMenu;
import model.game.menu.SettingsMenu;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import model.game.level.LevelFactory;

public class StartMenuController extends AbstractMenuController<Void, StartMenu> implements Controller<Void> {

    public StartMenuController(StartMenu menu, Gui gui) {
        super(menu, gui);
    }

    public Void update() throws Exception {
        Button selectedButton = menu.getSelectedButton();
        if (selectedButton.getOption() == Options.EXIT) {
            gui.getScreen().close();
        } else if (selectedButton.getOption() == Options.START) {
            GameController gameController = new GameController(
                    new Game(new LevelFactory(new GameConfiguration(Difficulty.MEDIUM))), gui);
            gameController.start();
            menu.resetSelection();

        } else if (selectedButton.getOption() == Options.SETTINGS) {
            SettingsMenuController settingsMenuController = new SettingsMenuController(new SettingsMenu(), gui);
            Difficulty chosen = settingsMenuController.start();
            GameController gameController = new GameController(
                    new Game(new LevelFactory(new GameConfiguration(chosen))), gui);
            gameController.start();
            menu.resetSelection();
        }

        else if (selectedButton.getOption() == Options.CONTROLS) {
            ControlsMenuController controlsMenuController = new ControlsMenuController(new ControlsMenu(), gui);
            controlsMenuController.start();
            menu.resetSelection();

        }

        return null;
    }
}
