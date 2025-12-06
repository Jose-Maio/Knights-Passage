package controller;

import com.googlecode.lanterna.input.KeyStroke;
import gui.Gui;
import gui.LanternaGui;
import model.Direction;
import model.game.Game;
import model.game.Level;
import view.GameView;

import java.io.IOException;

public class GameController {
    private Game game;
    private final MovementManager movementManager;
    private final GameView gameView;

    public GameController(Game game) throws Exception {
        this.game = game;
        this.movementManager = new MovementManager();
        this.gameView = new GameView();
    }


    public void start() throws IOException {

        while(!game.isGameOver()){

            gameView.render(game);

            update();

           /*try {
                Thread.sleep(50); // ~20 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
    }

    public Direction handleInput() throws IOException {
        return gameView.getGui().step();


    }


    public void update() throws IOException {
        Direction pressed = handleInput();
        Level level = game.getCurrentLevel();

        if(level.getPlayer().isDead()){
            game.setGameOver();
        }

        movementManager.movePlayer(level, pressed);

        movementManager.moveEnemies(level);

        if(level.isComplete()){
            game.nextLevel();
        }

    }
}

