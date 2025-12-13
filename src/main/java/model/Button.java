package model;

public class Button {
    private Options option;
    private boolean isHovered;
    private final Position position;

    public Button(Options option, Position position){
        this.option = option;
        this.position = position;
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

    public String toStringImg() {
        return option.toString() + (isHovered ? "_selected" : "");
    }

    public Position getPosition() {
        return position;
    }
}
