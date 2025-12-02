package controller;

import model.Direction;
import model.game.Game;

public class GameController {
    private Game game;

    GameController(Game game){
        this.game = game;
    }


    public void start(){
        while(!game.isGameOver()){
            Direction pressed = handleInput();

        }
    }

    public Direction handleInput(){
        return Direction.RIGHT;
    }
}
