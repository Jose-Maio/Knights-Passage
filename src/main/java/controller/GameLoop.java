package controller;

import controller.managers.InputManager;
import gui.Gui;
import model.game.Game;
import model.game.config.GameConstants;
import model.game.level.Level;
import view.GameView;

import java.io.IOException;

public class GameLoop {
    private final Game game;
    private final Gui gui;
    private final GameView gameView;
    private final LevelController levelController;
    private final InputManager inputManager;

    public GameLoop(Game game, Gui gui, GameView gameView, LevelController levelController, InputManager inputManager) {
        this.game = game;
        this.gui = gui;
        this.gameView = gameView;
        this.levelController = levelController;
        this.inputManager = inputManager;
    }

    public void run() throws Exception {       

        while (!game.isGameOver()) {
            if (inputManager.isExitPressed()) {
                gui.getScreen().close();
                return;
            }

            gameView.render(game);

            levelController.update(game.getCurrentLevel(), inputManager.getPressedDirections(),
                    inputManager.isAttackPressed());

            updateGameStatus();

            try {
                Thread.sleep(GameConstants.FRAME_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
        }
    }

    private void updateGameStatus() {
        Level level = game.getCurrentLevel();

        if (level.getPlayer().isDead()) {
            game.setGameOver();
        }

        if (level.isComplete()) {
            game.nextLevel();
            levelController.setHasSpawnedPlayer(false);
        }
    }
}
