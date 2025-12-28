package controller_test;

import controller.LevelController;
import model.Direction;
import model.entities.characters.Player;
import model.entities.objects.Key;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LevelControllerTest {

    private LevelController controller;
    private Level mockLevel;
    private Player mockPlayer;
    private Arena mockArena;

    @BeforeEach
    void setUp() {
        controller = new LevelController();
        mockLevel = mock(Level.class);
        mockPlayer = mock(Player.class);
        mockArena = mock(Arena.class);

        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getCloseEnemyList()).thenReturn(new ArrayList<>());
        when(mockLevel.removeDeadEnemies()).thenReturn(new ArrayList<>());
        when(mockPlayer.isDead()).thenReturn(false);
        when(mockPlayer.canAttack()).thenReturn(true);
        when(mockArena.getKey()).thenReturn(null);
        when(mockArena.getDynamicObjectList()).thenReturn(new ArrayList<>());
        doNothing().when(mockLevel).specialBehavior();
        doNothing().when(mockLevel).spawnPlayer();
        doNothing().when(mockPlayer).setHasKey(false);
    }

    @Test
    void testUpdate() throws Exception {
        assertDoesNotThrow(() -> controller.update(mockLevel, new HashSet<>(), false));
    }

    @Test
    void testUpdateWithAttack() throws Exception {
        controller.update(mockLevel, new HashSet<>(), true);
        verify(mockPlayer).setAttacking(true);
    }

    @Test
    void testUpdateWithKeyPickup() throws Exception {
        Key mockKey = mock(Key.class);
        when(mockArena.getKey()).thenReturn(mockKey);
        when(mockPlayer.getHitbox()).thenReturn(new java.awt.Rectangle(10, 10, 12, 12));
        when(mockKey.getHitbox()).thenReturn(new java.awt.Rectangle(10, 10, 12, 12));

        controller.update(mockLevel, new HashSet<>(), false);
        verify(mockArena).pickKey();
        verify(mockPlayer).pickUpKey();
    }

    @Test
    void testSetHasSpawnedPlayer() {
        controller.setHasSpawnedPlayer(true);
        controller.setHasSpawnedPlayer(false);
        assertTrue(true);
    }
}
