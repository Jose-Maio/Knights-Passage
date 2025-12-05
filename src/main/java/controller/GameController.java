package controller;

import com.googlecode.lanterna.input.KeyStroke;
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

            try {
                Thread.sleep(50); // ~20 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public Direction handleInput() throws IOException {

        KeyStroke keyStroke = gameView.getGui().getScreen().readInput();

        if (keyStroke != null) {
            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    return Direction.UP;
                case ArrowDown:
                    return  Direction.DOWN;
                case ArrowLeft:
                    return Direction.LEFT;
                case ArrowRight:
                    return Direction.RIGHT;

            }
        }
        return null;
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

        if(game.isGameOver()){
            return;
        }

    }
}

