package model.game.menu;

import model.Button;
import model.Options;
import model.Position;

import java.util.List;

public class SettingsMenu extends Menu{

    public SettingsMenu(){
        this.buttons = List.of(new Button(Options.EASY_MODE, new Position(92, 60)),
                new Button(Options.MEDIUM_MODE, new Position(83,90)),
                new Button(Options.HARD_MODE, new Position(93, 120)));
        updateCurrentButton(true);

    }

}
