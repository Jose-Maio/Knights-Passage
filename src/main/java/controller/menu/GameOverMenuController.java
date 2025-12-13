package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import gui.Gui;
import model.Button;
import model.Options;
import model.game.menu.GameOverMenu;
import model.game.menu.StartMenu;
import view.MenuView;
import java.io.IOException;

public class GameOverMenuController {
    private final GameOverMenu menu;
    private final MenuView menuView;
    private final Gui gui;

    public GameOverMenuController(GameOverMenu menu , Gui gui){
        this.menu = menu;
        this.gui = gui;
        this.menuView = new MenuView(gui);
    }

    public void start() throws Exception {

        while(!menu.isSelected()){

            menuView.render(menu);

            handleInput();


        }
        update();
    }

    public void handleInput() throws IOException {
        KeyStroke keystroke = gui.step();
        if(keystroke == null) return;

        switch (keystroke.getKeyType()) {
            case ArrowUp -> menu.previousOption();
            case ArrowDown -> menu.nextOption();
            case Enter -> menu.setSelected(true);
        };
    }

    public void update() throws Exception {
        Button selectedButton = menu.getSelectedButton();
        if (selectedButton.getOption() == Options.BACK) {
            StartMenuController startMenuController = new StartMenuController(new StartMenu(), gui);
            startMenuController.start();
        } else if (selectedButton.getOption() == Options.EXIT) {
            gui.getScreen().close();

        }
    }

};
