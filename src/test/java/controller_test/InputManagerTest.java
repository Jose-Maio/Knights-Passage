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
    private InputManager inputManager;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        inputManager = new InputManager(mockGui);
    }

    @Test
    void testGetPressedDirectionsAll() {
        Set<Integer> keys = new HashSet<>();
        keys.add(KeyEvent.VK_UP);
        keys.add(KeyEvent.VK_DOWN);
        keys.add(KeyEvent.VK_LEFT);
        keys.add(KeyEvent.VK_RIGHT);

        when(mockGui.getActiveKeys()).thenReturn(keys);

        HashSet<Direction> result = inputManager.getPressedDirections();

        assertEquals(4, result.size());
        assertTrue(result.contains(Direction.UP));
        assertTrue(result.contains(Direction.DOWN));
        assertTrue(result.contains(Direction.LEFT));
        assertTrue(result.contains(Direction.RIGHT));
    }

    @Test
    void testGetPressedDirectionsNone() {
        when(mockGui.getActiveKeys()).thenReturn(new HashSet<>());

        HashSet<Direction> result = inputManager.getPressedDirections();

        assertTrue(result.isEmpty());
    }

    @Test
    void testIsAttackPressed() {
        when(mockGui.getActiveKeys()).thenReturn(Set.of(KeyEvent.VK_E));
        assertTrue(inputManager.isAttackPressed());

        when(mockGui.getActiveKeys()).thenReturn(new HashSet<>());
        assertFalse(inputManager.isAttackPressed());
    }

    @Test
    void testIsExitPressed() {
        when(mockGui.getActiveKeys()).thenReturn(Set.of(KeyEvent.VK_Q));
        assertTrue(inputManager.isExitPressed());

        when(mockGui.getActiveKeys()).thenReturn(new HashSet<>());
        assertFalse(inputManager.isExitPressed());
    }
}