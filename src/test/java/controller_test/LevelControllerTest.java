package controller_test;

import controller.LevelController;
import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.objects.BloodDrops;
import model.entities.objects.Key;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

class LevelControllerTest {
    private LevelController levelController;
    private Level mockLevel;
    private Arena mockArena;
    private Player mockPlayer;

    @BeforeEach
    void setUp() {
        levelController = new LevelController();
        mockLevel = mock(Level.class);
        mockArena = mock(Arena.class);
        mockPlayer = mock(Player.class);

        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getPlayer()).thenReturn(mockPlayer);
        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(0, 0, 10, 10));
    }


    @Test
    void testBloodSpawnOnEnemyDeath() throws IOException {
        levelController.setHasSpawnedPlayer(true);

        Position deathPos = new Position(10, 10);
        List<Position> deadPositions = List.of(deathPos);
        when(mockLevel.removeDeadEnemies()).thenReturn(deadPositions);

        List mockDynamicList = mock(List.class);
        when(mockArena.getDynamicObjectList()).thenReturn(mockDynamicList);

        when(mockPlayer.isDead()).thenReturn(false);
        when(mockPlayer.canAttack()).thenReturn(false);

        levelController.update(mockLevel, new HashSet<>(), false);

        verify(mockDynamicList).add(any(BloodDrops.class));
    }

    @Test
    void testUpdatePlayerDeadSkipsMovement() throws IOException {
        when(mockPlayer.isDead()).thenReturn(true);
        levelController.setHasSpawnedPlayer(true);

        HashSet<Direction> inputs = new HashSet<>();
        inputs.add(Direction.RIGHT);

        levelController.update(mockLevel, inputs, false);

        verify(mockPlayer, never()).nextPos(any());
    }

    @Test
    void testEnemyUpdateDelay() throws IOException {
        levelController.setHasSpawnedPlayer(true);
        when(mockLevel.removeDeadEnemies()).thenReturn(new ArrayList<>());

        levelController.update(mockLevel, new HashSet<>(), false);
        verify(mockLevel, times(1)).removeDeadEnemies();

        levelController.update(mockLevel, new HashSet<>(), false);
        verify(mockLevel, times(1)).removeDeadEnemies();
    }


    @Test
    void testKeyPickup() throws IOException {
        levelController.setHasSpawnedPlayer(true);
        Key mockKey = mock(Key.class);
        when(mockArena.getKey()).thenReturn(mockKey);

        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(0, 0, 10, 10));
        when(mockKey.getHitbox()).thenReturn(new Rectangle(2, 2, 5, 5));

        levelController.update(mockLevel, new HashSet<>(), false);

        verify(mockArena).pickKey();
        verify(mockPlayer).pickUpKey();
    }

    @Test
    void testKeyNoPickupWhenFar() throws IOException {
        levelController.setHasSpawnedPlayer(true);
        Key mockKey = mock(Key.class);
        when(mockArena.getKey()).thenReturn(mockKey);

        when(mockPlayer.getHitbox()).thenReturn(new Rectangle(0, 0, 10, 10));
        when(mockKey.getHitbox()).thenReturn(new Rectangle(50, 50, 5, 5));

        levelController.update(mockLevel, new HashSet<>(), false);

        verify(mockArena, never()).pickKey();
    }
}