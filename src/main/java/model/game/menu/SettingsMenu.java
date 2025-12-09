package model.game.menu;

import model.Options;

public class SettingsMenu extends Menu{

    public SettingsMenu(){
        this.currOption = Options.EASY_MODE;
    }

    @Override
    public void nextOption(){
        switch (currOption){
            case EASY_MODE:
                currOption = Options.MEDIUM_MODE;
                break;
            case MEDIUM_MODE:
                currOption = Options.HARD_MODE;
                break;
            case HARD_MODE:
                currOption = Options.EASY_MODE;
                break;
        }
    }

    @Override
    public void previousOption(){
        switch (currOption){
            case EASY_MODE:
                currOption = Options.HARD_MODE;
                break;
            case MEDIUM_MODE:
                currOption = Options.EASY_MODE;
                break;
            case HARD_MODE:
                currOption = Options.MEDIUM_MODE;
                break;
        }
    }

}
