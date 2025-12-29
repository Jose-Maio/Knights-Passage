package model_test;

import model.Position;
import model.entities.characters.Player;
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

class KeyCollectedRuleTest {

    private KeyCollectedRule rule;
    private Level level;
    private Player player;

    @BeforeEach
    void setUp() {
        rule = new KeyCollectedRule();
        player = new Player(20, 5);
        List<model.entities.objects.Object> staticObjects = new ArrayList<>();
        List<model.entities.objects.Object> dynamicObjects = new ArrayList<>();
        Arena arena = new Arena(staticObjects, dynamicObjects, "bg.png", new Rectangle(0, 0, 400, 208));
        level = new Level(new ArrayList<>(), arena, new Position(0, 0), new Rectangle(0, 0, 10, 10), player, rule, null);
    }

    @Test
    void testIsCompleteWithoutKey() {
        assertFalse(rule.isComplete(level));
    }

    @Test
    void testIsCompleteWithKey() {
        player.pickUpKey();
        assertTrue(rule.isComplete(level));
    }
}

