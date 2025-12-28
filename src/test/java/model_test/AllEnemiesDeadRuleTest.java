package model_test;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.level.CompletionRules.AllEnemiesDeadRule;
import model.game.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllEnemiesDeadRuleTest {

    private AllEnemiesDeadRule rule;
    private Level level;

    @BeforeEach
    void setUp() {
        rule = new AllEnemiesDeadRule();
        Player player = new Player(20, 5);
        List<model.entities.characters.enemies.Enemy> enemies = new ArrayList<>();
        enemies.add(new ForestEnemy(new Position(10, 10), 10, 2));
        Arena arena = new Arena(new ArrayList<>(), new ArrayList<>(), "bg.png", new Rectangle(0, 0, 400, 208));
        level = new Level(enemies, arena, new Position(0, 0), new Rectangle(0, 0, 10, 10), player, rule, null);
    }

    @Test
    void testIsCompleteWithEnemies() {
        assertFalse(rule.isComplete(level));
    }

    @Test
    void testIsCompleteWithoutEnemies() {
        level.getEnemyList().forEach(enemy -> enemy.takeDamage(1000));
        level.removeDeadEnemies();
        assertTrue(rule.isComplete(level));
    }
}

