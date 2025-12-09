package model;

public class Button {
    private Options option;
    private boolean isHovered;

    Button(Options option){
        this.option = option;
    }

    public Options getOption() {
        return option;
    }

    public void setHovered(boolean hovered) {
        isHovered = hovered;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    public boolean isHovered() {
        return isHovered;
    }
}
