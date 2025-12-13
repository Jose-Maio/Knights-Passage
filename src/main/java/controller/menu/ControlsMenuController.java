package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import gui.Gui;
import model.game.menu.ControlsMenu;
import view.MenuView;

import java.io.IOException;

public class ControlsMenuController {
    private final ControlsMenu menu;
    private final MenuView menuView;
    private final Gui gui;

    public ControlsMenuController(ControlsMenu menu, Gui gui){
        this.menu = menu;
        this.gui = gui;
        this.menuView = new MenuView(gui);
    }

    public void start() throws Exception {

        while(!menu.isSelected()){

            menuView.render(menu);

            handleInput();


        }


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
}
