package controller;

import controller.managers.InputManager;
import controller.menu.GameOverMenuController;
import gui.Gui;
import model.Direction;
import model.game.Game;
import model.game.level.Level;
import model.game.menu.GameOverMenu;
import view.GameView;
import model.game.config.GameConstants;

import java.io.IOException;
import java.util.HashSet;

public class GameController implements Controller<Void> {
    private final Game game;
    private final GameView gameView;
    private final Gui gui;
    private final LevelController levelController;
    private final InputManager inputManager;

    public GameController(Game game, Gui gui) throws Exception {
        this.game = game;
        this.gameView = new GameView(gui);
        this.gui = gui;
        this.levelController = new LevelController();
        this.inputManager = new InputManager(gui);
    }

    @Override
    public Void start() throws Exception {

        new GameLoop(game, gui, gameView, levelController, inputManager).run();
        GameOverMenu gameOverMenu = new GameOverMenu(game);
        gameOverMenu.resetSelection();
        GameOverMenuController gameOverMenuController = new GameOverMenuController(gameOverMenu, gui);
        gui.clearInput();
        gameOverMenuController.start();
        return null;
    }

    @Override
    public void handleInput()  {
        // Handled by GameLoop
    }

    @Override
    public Void update() throws Exception {
        // Handled by GameLoop
        return null;
    }

}
