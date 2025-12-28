package controller_test;

import controller.managers.InputManager;
import gui.Gui;
import model.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InputManagerTest {

    private Gui mockGui;
    private InputManager inputManager;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        inputManager = new InputManager(mockGui);
    }

    @Test
    void testGetPressedDirections() {
        Set<Integer> activeKeys = new HashSet<>();
        activeKeys.add(KeyEvent.VK_UP);
        activeKeys.add(KeyEvent.VK_RIGHT);
        when(mockGui.getActiveKeys()).thenReturn(activeKeys);

        HashSet<Direction> directions = inputManager.getPressedDirections();
        assertTrue(directions.contains(Direction.UP));
        assertTrue(directions.contains(Direction.RIGHT));
    }

    @Test
    void testIsAttackPressed() {
        Set<Integer> activeKeys = new HashSet<>();
        activeKeys.add(KeyEvent.VK_E);
        when(mockGui.getActiveKeys()).thenReturn(activeKeys);
        assertTrue(inputManager.isAttackPressed());
    }

    @Test
    void testIsExitPressed() {
        Set<Integer> activeKeys = new HashSet<>();
        activeKeys.add(KeyEvent.VK_Q);
        when(mockGui.getActiveKeys()).thenReturn(activeKeys);
        assertTrue(inputManager.isExitPressed());
    }
}
