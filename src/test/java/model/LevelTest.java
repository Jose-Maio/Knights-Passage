package model;

import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Tree;
import model.game.Arena;
import model.game.level.Level;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LevelTest {
    private Key key;
    private Arena arena;

    Level createSimpleLevel() {
        Player p = new Player(20, 5);

        ForestEnemy enemy = new ForestEnemy(new Position(10, 10), 10, 2);

        key = new Key(new Position(5, 5));

        arena = new Arena(List.of(new Tree(new Position(20, 20))), "bg", new Rectangle(0,0,400,208));
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(enemy);
        return new Level(enemies, arena, new Position(0, 0), new Rectangle(40,40 , 10 ,10) , p);
    }                                                 // entry                   // exit

    @Test
    void testKeyPickupDuringUpdate() {
        Level level = createSimpleLevel();
        Player p = level.getPlayer();

        p.setPosition(new Position(5, 5));
        //level.update(Direction.RIGHT);

        assertTrue(p.hasKey());
    }

    @Test
    void testEnemyDiesAndRemovedFromList() {
        Level level = createSimpleLevel();
        ForestEnemy e = (ForestEnemy) level.getEnemyList().get(0);

        // kill enemy
        e.takeDamage(1000);
        //level.update(Direction.RIGHT);

        assertEquals(0, level.getEnemyList().size());
    }

    @Test
    void testLevelCompletion() {
        Level level = createSimpleLevel();
        Player p = level.getPlayer();

        // make the position of player == the one of key so that player picks up key
        p.setPosition(new Position(5, 5));
        //level.update(Direction.RIGHT);

        // move to exit pos            // exit
        p.setPosition(new Position(100, 100));

        assertTrue(level.isComplete());
    }

    @Test
    void testGetArena() {
        Level level = createSimpleLevel();
        assertEquals(arena, level.getArena());
    }


    @Test
    void testGetKey() {
        Level level = createSimpleLevel();
        //assertEquals(key, level.getKey());
    }


}