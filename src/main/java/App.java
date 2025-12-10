import controller.menu.StartMenuController;
import gui.LanternaGui;
import model.game.menu.StartMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    private final LanternaGui gui;

    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGui();
    }

    public static void main(String[] args) throws Exception {

        new App().start();

    }

    public void start() throws Exception {
        StartMenu menu = new StartMenu();
        StartMenuController menuController= new StartMenuController(menu,gui);

        menuController.start();
    }
}