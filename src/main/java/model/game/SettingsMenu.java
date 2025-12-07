package model.game;

import model.Options;

public class SettingsMenu {
    private boolean selected = false;
    private Options currOption;

    public SettingsMenu(){
        this.currOption = Options.EASY_MODE;
    }

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

    public Options getCurrOption() {
        return currOption;
    }

    public void setSelected() {
        this.selected = true;
    }

    public boolean isSelected() {
        return selected;
    }
}
