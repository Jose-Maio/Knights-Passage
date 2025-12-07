package model.game;

import model.Options;

public class StartMenu {
    private boolean selected = false;
    private Options currOption;

    public StartMenu(){
        this.currOption = Options.START;
    }

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
