package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import controller.Controller;
import controller.GameController;
import gui.Gui;
import model.Options;
import model.game.Game;
import model.game.menu.StartMenu;
import model.game.menu.SettingsMenu;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import view.StartMenuView;

import java.io.IOException;


public class StartMenuController implements Controller<Void> {
    private final StartMenu menu;
    private final StartMenuView menuView;
    private final Gui gui;

    public StartMenuController(StartMenu menu, Gui gui) throws Exception {
        this.menu = menu;
        this.gui = gui;
        this.menuView = new StartMenuView(gui);
    }

    public Void start() throws Exception {

        while(!menu.isSelected()){

            menuView.render(menu);

            handleInput();


        }
        update();
        return  null;
    }

    public void handleInput() throws IOException {
        KeyStroke keystroke = gui.step();
        if(keystroke == null) return;

        switch (keystroke.getKeyType()) {
            case ArrowUp -> menu.previousOption();
            case ArrowDown -> menu.nextOption();
            case Enter -> menu.setSelected();
        };
    }

    public Void update() throws Exception {
        if(menu.getCurrOption() == Options.EXIT){
            gui.getScreen().close();
        }
        else if(menu.getCurrOption() == Options.START){
            GameController gameController = new GameController(new Game(new GameConfiguration(Difficulty.MEDIUM)), gui);
            gameController.start();

        }
        else if (menu.getCurrOption() == Options.SETTINGS){
            SettingsMenuController settingsMenuController = new SettingsMenuController(new SettingsMenu(), gui);
            Difficulty chosen = settingsMenuController.start();
            GameController gameController = new GameController(new Game(new GameConfiguration(chosen)), gui);
            gameController.start();
        }

        return  null;
    }
}
