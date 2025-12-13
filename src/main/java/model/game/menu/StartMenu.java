package model.game.menu;

import model.Button;
import model.Options;
import model.Position;

import java.util.List;

public class StartMenu extends Menu {

    public StartMenu(){
        this.buttons = List.of(new Button(Options.START, new Position(92, 60)),
                new Button(Options.SETTINGS, new Position(83,85)),
                new Button(Options.CONTROLS, new Position(72, 110)),
                new Button(Options.EXIT, new Position(102,135))
               );
        updateCurrentButton(true);
    }



}
