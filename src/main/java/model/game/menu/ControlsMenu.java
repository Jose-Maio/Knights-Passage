package model.game.menu;

import model.Button;
import model.Options;
import model.Position;

import java.util.List;

public class ControlsMenu extends Menu{

    public ControlsMenu(){
        this.buttons = List.of(new Button(Options.BACK, new Position(100, 135)));
        updateCurrentButton(true);

        this.backgroundImg = "sprites/menu/bg.png";

    }

}
