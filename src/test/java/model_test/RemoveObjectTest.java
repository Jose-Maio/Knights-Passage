package model_test;

import model.Position;
import model.entities.characters.enemies.Enemy;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.BloodDrops;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.level.Level;
import model.game.level.SpecialBehavior.RemoveObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RemoveObjectTest {
    private RemoveObject removeObject;
    private Level level;
    private Arena arena;
    private List<Enemy> enemies;
    private List<model.entities.objects.Object> dynamicObjects;

    @BeforeEach
    void setUp() {
        removeObject = new RemoveObject();
        level = mock(Level.class);
        arena = mock(Arena.class);
        enemies = new ArrayList<>();
        dynamicObjects = new ArrayList<>();

        when(level.getEnemyList()).thenReturn(enemies);
        when(level.getArena()).thenReturn(arena);
        when(arena.getDynamicObjectList()).thenReturn(dynamicObjects);
    }

    @Test
    void testBehaviorWithEnemies() {

        enemies.add(mock(ForestEnemy.class));

        Tree genericObject = new Tree(new Position(0, 0));
        dynamicObjects.add(genericObject);

        removeObject.behavior(level);

        assertEquals(1, dynamicObjects.size());
        assertTrue(dynamicObjects.contains(genericObject));
    }

    @Test
    void testBehaviorWithNoEnemies() {

        enemies.clear();

        Key key = new Key(new Position(1, 1));
        BloodDrops blood = new BloodDrops(new Position(2, 2));
        Tree tree = new Tree(new Position(3, 3)); // This should be removed

        dynamicObjects.add(key);
        dynamicObjects.add(blood);
        dynamicObjects.add(tree);


        removeObject.behavior(level);
        
        assertEquals(2, dynamicObjects.size());
        assertTrue(dynamicObjects.contains(key));
        assertTrue(dynamicObjects.contains(blood));
        assertFalse(dynamicObjects.contains(tree));
    }
}