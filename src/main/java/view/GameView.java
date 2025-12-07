package view;


import gui.Gui;
import gui.LanternaGui;
import model.game.Game;
import java.awt.*;
import java.io.IOException;

public class GameView {

    private final Gui gui;
    private final LevelRenderer lr = new LevelRenderer();


    public GameView(Gui gui) throws IOException {
        this.gui = gui;

    }

    public void render(Game game) throws IOException {

        lr.render(game.getCurrentLevel(), gui);

        gui.refresh();
    }

    public Gui getGui() {
        return gui;
    }


}


