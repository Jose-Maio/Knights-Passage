package controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import controller.Controller;
import gui.Gui;
import model.game.menu.Menu;
import view.MenuView;
import java.io.IOException;


public abstract class AbstractMenuController<T, M extends Menu> implements Controller<T> {
    protected final M menu;
    protected final MenuView menuView;
    protected final Gui gui;

    public AbstractMenuController(M menu, Gui gui) {
        this.menu = menu;
        this.gui = gui;
        this.menuView = new MenuView(gui);
    }

    @Override
    public T start() throws Exception {
        while (!menu.isSelected()) {
            menuView.render(menu);
            handleInput();
        }
        return update();
    }

    @Override
    public void handleInput() throws IOException {
        KeyStroke keystroke = gui.step();
        if (keystroke == null) return;

        switch (keystroke.getKeyType()) {
            case ArrowUp -> menu.previousOption();
            case ArrowDown -> menu.nextOption();
            case Enter -> menu.setSelected(true);
        }
    }


    @Override
    public abstract T update() throws Exception;
}