package model_test;

import model.entities.objects.Key;
import model.game.Arena;
import model.game.level.Level;
import model.entities.characters.enemies.Enemy;
import model.game.level.SpecialBehavior.EnemiesDropKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class EnemiesDropKeyTest {
    private EnemiesDropKey enemiesDropKey;
    private Key mockKey;
    private Level mockLevel;
    private Arena mockArena;
    private List<Enemy> enemyList;

    @BeforeEach
    void setUp() {
        mockKey = mock(Key.class);
        mockLevel = mock(Level.class);
        mockArena = mock(Arena.class);
        enemyList = new ArrayList<>();

        enemiesDropKey = new EnemiesDropKey(mockKey);

        when(mockLevel.getArena()).thenReturn(mockArena);
        when(mockLevel.getEnemyList()).thenReturn(enemyList);
    }

    @Test
    void testBehaviorWithEnemies() {

        enemyList.add(mock(Enemy.class));

        enemiesDropKey.behavior(mockLevel);

        verify(mockArena, never()).placeKey(any());
    }

    @Test
    void testBehaviorWithNoEnemies() {

        enemiesDropKey.behavior(mockLevel);

        verify(mockArena, times(1)).placeKey(mockKey);
    }

    @Test
    void testBehaviorDoesNotDropKeyTwice() {

        enemiesDropKey.behavior(mockLevel);
        verify(mockArena, times(1)).placeKey(mockKey);

        enemiesDropKey.behavior(mockLevel);

        verify(mockArena, times(1)).placeKey(mockKey);
    }
}