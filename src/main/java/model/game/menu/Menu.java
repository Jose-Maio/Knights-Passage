package model.game.menu;

import model.Options;

public abstract class Menu {

    protected boolean selected = false;
    protected Options currOption;

    public Options getCurrOption() {
        return currOption;
    }

    public void setSelected() {
        this.selected = true;
    }

    public boolean isSelected() {
        return selected;
    }

    public abstract void nextOption();

    public abstract void previousOption();
}
