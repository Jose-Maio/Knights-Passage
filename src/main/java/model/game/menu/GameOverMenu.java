package model.game.menu;

import model.Button;
import model.Options;
import model.Position;
import model.game.Game;

import java.util.List;

public class GameOverMenu extends Menu {

    public GameOverMenu(Game game){
        this.buttons = List.of(new Button(Options.BACK, new Position(100,120)),
                new Button(Options.EXIT, new Position(100,140)));
        this.backgroundImg = game.isWin() ? "sprites/game_over_victory.png" : "sprites/game_over_dead.png";
    }
}
