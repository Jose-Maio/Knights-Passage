package model.game.menu;

import model.Button;
import java.util.List;

public abstract class Menu {

    private boolean isSelected = false;
    protected int currentIndex = 0;
    protected List<Button> buttons;
    protected String backgroundImg = "sprites/menu/menu_bg.png";


    public Button getSelectedButton() {
        return buttons.get(currentIndex);
    }

    public void nextOption() {
        updateCurrentButton(false);
        currentIndex = (currentIndex + 1) % buttons.size();
        updateCurrentButton(true);
    }

    public void previousOption() {
        updateCurrentButton(false);
        currentIndex = (currentIndex - 1 + buttons.size()) % buttons.size();
        updateCurrentButton(true);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void updateCurrentButton(Boolean value){
        Button button = buttons.get(currentIndex);
        button.setHovered(value);
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void resetSelection() {
        isSelected = false;
        updateCurrentButton(false);
        currentIndex = 0;
        updateCurrentButton(true);
    }

}
