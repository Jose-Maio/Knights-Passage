package controller.managers;

import gui.Gui;
import model.Direction;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class InputManager {
    private final Gui gui;
    private final HashSet<Direction> directions = new HashSet<>();

    public InputManager(Gui gui) {
        this.gui = gui;
    }

    public HashSet<Direction> getPressedDirections() {
        directions.clear();
        Set<Integer> activeKeys = gui.getActiveKeys();

        if (activeKeys.contains(KeyEvent.VK_UP))
            directions.add(Direction.UP);
        if (activeKeys.contains(KeyEvent.VK_DOWN))
            directions.add(Direction.DOWN);
        if (activeKeys.contains(KeyEvent.VK_LEFT))
            directions.add(Direction.LEFT);
        if (activeKeys.contains(KeyEvent.VK_RIGHT))
            directions.add(Direction.RIGHT);

        return directions;
    }

    public boolean isAttackPressed() {
        return gui.getActiveKeys().contains(KeyEvent.VK_E);
    }

    public boolean isExitPressed() {
        return gui.getActiveKeys().contains(KeyEvent.VK_Q);
    }
}
