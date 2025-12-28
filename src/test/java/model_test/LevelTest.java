package model_test;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.level.CompletionRules.KeyCollectedRule;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<model.entities.characters.enemies.Enemy> enemies = new ArrayList<>();
        enemies.add(new ForestEnemy(new Position(10, 10), 10, 2));

        Key key = new Key(new Position(5, 5));
        List<model.entities.objects.Object> staticObjects = new ArrayList<>();
        staticObjects.add(new Tree(new Position(20, 20)));
        List<model.entities.objects.Object> dynamicObjects = new ArrayList<>();
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
        player.pickUpKey();
        player.setPosition(new Position(42, 42));
        assertTrue(level.isComplete());
    }

    @Test
    void testRemoveDeadEnemies() {
        model.entities.characters.enemies.Enemy enemy = level.getEnemyList().get(0);
        enemy.takeDamage(1000);
        List<Position> deadPositions = level.removeDeadEnemies();
        assertEquals(1, deadPositions.size());
        assertEquals(0, level.getEnemyList().size());
    }

    @Test
    void testSpawnPlayer() {
        level.spawnPlayer();
        assertEquals(0, player.getPosition().getX());
        assertEquals(0, player.getPosition().getY());
    }
}
