package controller;

import model.Direction;
import model.game.Game;
import model.game.Level;
import view.GameView;

import java.io.IOException;

public class GameController {
    private Game game;
    private MovementManager movementManager;
    private GameView gameView;

    public GameController(Game game) throws Exception {
        this.game = game;
        this.movementManager = new MovementManager();
        this.gameView = new GameView();
    }


    public void start() throws IOException {
        while(!game.isGameOver()){
            gameView.render(game);
            Level curr = game.getCurrentLevel();
            Direction pressed = handleInput();

            movementManager.movePlayer(curr, pressed);

            movementManager.moveEnemies(curr);

            gameView.render(game);


        }
    }

    public Direction handleInput(){
        return Direction.UP;
    }
}
