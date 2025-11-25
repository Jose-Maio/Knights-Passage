package view;


import gui.LanternaGui;
import model.game.Game;
import java.awt.*;
import java.io.IOException;

public class GameView {

    private final LanternaGui gui;

    public GameView() throws Exception {
        this.gui = new LanternaGui();
    }

    public void render(Game game) throws IOException {
        gui.clear();

        LevelRenderer lr = new LevelRenderer();
        lr.render(game.getCurrentLevel(), gui);

        gui.refresh();
    }
}


