package view;


import gui.Gui;
import gui.LanternaGui;
import model.game.Game;
import java.awt.*;
import java.io.IOException;

public class GameView {

    private final Gui gui;
    private final LevelRenderer lr;

    public GameView() throws Exception {
        this.gui = new LanternaGui();
        this.lr = new LevelRenderer();
    }
    public GameView(Gui gui, LevelRenderer levelRenderer) {
        this.gui = gui;
        this.lr = levelRenderer;
    }

    public void render(Game game) throws IOException {

        lr.render(game.getCurrentLevel(), gui);

        gui.refresh();
    }
}


