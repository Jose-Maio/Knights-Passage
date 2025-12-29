package model_test;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.level.CompletionRules.KeyCollectedRule;
import model.game.level.Level;
import model.game.level.SpecialBehavior.LevelSpecialBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    private Level level;
    private Player player;
    private Arena arena;

    @BeforeEach
    void setUp() {
        player = new Player(20, 5);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new ForestEnemy(new Position(10, 10), 10, 2));

        Key key = new Key(new Position(5, 5));
        List<Object> staticObjects = new ArrayList<>();
        staticObjects.add(new Tree(new Position(20, 20)));
        List<Object> dynamicObjects = new ArrayList<>();
        dynamicObjects.add(key);

        arena = new Arena(staticObjects, dynamicObjects, "bg.png", new Rectangle(0, 0, 400, 208));
        Position entryPosition = new Position(0, 0);
        Rectangle exitPosition = new Rectangle(40, 40, 10, 10);

        level = new Level(enemies, arena, entryPosition, exitPosition, player, new KeyCollectedRule(), null);
    }

    @Test
    void testGetters() {
        assertEquals(1, level.getEnemyList().size());
        assertEquals(arena, level.getArena());
        assertEquals(player, level.getPlayer());
    }

    @Test
    void testLevelCompletion() {
        arena.pickKey();
        assertFalse(level.isComplete());
        player.pickUpKey();
        assertFalse(level.isComplete());
        player.setPosition(new Position(42, 42));
        assertTrue(level.isComplete());
    }

    @Test
    void testRemoveDeadEnemies() {
        Enemy enemy = level.getEnemyList().getFirst();
        enemy.takeDamage(1);
        List<Position> deadPositions = level.removeDeadEnemies();
        assertEquals(0, deadPositions.size());
        assertEquals(1, level.getEnemyList().size());
        enemy.takeDamage(100);
        deadPositions = level.removeDeadEnemies();
        assertEquals(1, deadPositions.size());
        assertEquals(0, level.getEnemyList().size());
    }

    @Test
    void testSpawnPlayer() {
        level.spawnPlayer();
        assertEquals(0, player.getPosition().getX());
        assertEquals(0, player.getPosition().getY());
    }

    @Test
    void testGetCloseEnemyList() {
        level.getEnemyList().clear();
        Enemy closeEnemy = new ForestEnemy(new Position(0, 0), 10, 2);
        Enemy farEnemy = new ForestEnemy(new Position(300, 300), 10, 2);

        level.getEnemyList().add(closeEnemy);
        level.getEnemyList().add(farEnemy);

        player.setPosition(new Position(0, 0));

        List<Enemy> result = level.getCloseEnemyList();

        assertEquals(1, result.size());
        assertTrue(result.contains(closeEnemy));
        assertFalse(result.contains(farEnemy));
    }

    @Test
    void testSpecialBehaviorNotNull() {

        LevelSpecialBehavior mockBehavior = Mockito.mock(LevelSpecialBehavior.class);

        Level levelWithBehavior = new Level(
                level.getEnemyList(),
                level.getArena(),
                new Position(0,0),
                new Rectangle(40,40,10,10),
                player,
                new KeyCollectedRule(),
                mockBehavior
        );

        levelWithBehavior.specialBehavior();

        Mockito.verify(mockBehavior, Mockito.times(1)).behavior(levelWithBehavior);
    }

    @Test
    void testSpecialBehaviorNull() {
        assertDoesNotThrow(() -> level.specialBehavior());
    }
}
