package model.game.menu;

import model.Options;

public class StartMenu extends Menu {

    public StartMenu(){
        this.currOption = Options.START;
    }

    @Override
    public void nextOption(){
        switch (currOption){
            case START:
                currOption = Options.SETTINGS;
                break;
            case SETTINGS:
                currOption = Options.EXIT;
                break;
            case EXIT:
                currOption = Options.START;
                break;
        }
    }

    @Override
    public void previousOption(){
        switch (currOption){
            case START:
                currOption = Options.EXIT;
                break;
            case SETTINGS:
                currOption = Options.START;
                break;
            case EXIT:
                currOption = Options.SETTINGS;
                break;
        }
    }

}
