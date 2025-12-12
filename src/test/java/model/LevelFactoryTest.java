package model;

import model.entities.characters.enemies.Enemy;
import model.game.Arena;
import model.game.level.Level;
import model.game.level.LevelFactory;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LevelFactoryTest {
    @Test
    void testGetInstanceReturnsSingleton() {
        GameConfiguration config1 = new GameConfiguration(Difficulty.MEDIUM);
        GameConfiguration config2 = new GameConfiguration(Difficulty.EASY);

        LevelFactory factory1 = LevelFactory.getInstance(config1);
        LevelFactory factory2 = LevelFactory.getInstance(config2);

        assertSame(factory1, factory2);
    }

    @Test
    void testCreateLevel1AppliesEnemyMultipliers() {
        GameConfiguration config = new GameConfiguration(Difficulty.MEDIUM);
        LevelFactory factory = LevelFactory.getInstance(config);


        Level level = factory.createLevel1();
        List<Enemy> enemies = level.getEnemyList();

        Enemy firstEnemy = enemies.getFirst();
        Enemy secondEnemy = enemies.get(1);
        Enemy thirdEnemy = enemies.get(2);
        Enemy fourthEnemy = enemies.get(3);

        assertEquals(50, firstEnemy.getHealth());
        assertEquals(10, firstEnemy.getDamage());
        assertEquals(50, secondEnemy.getHealth());
        assertEquals(10, secondEnemy.getDamage());
        assertEquals(50, thirdEnemy.getHealth());
        assertEquals(10, thirdEnemy.getDamage());
        assertEquals(50, fourthEnemy.getHealth());
        assertEquals(10, fourthEnemy.getDamage());
    }

    @Test
    void testCreateArena1ReturnsValidArena() {
        LevelFactory factory = LevelFactory.getInstance(new GameConfiguration(Difficulty.MEDIUM));
        Arena arena = factory.createArena1();

        assertNotNull(arena);
        assertFalse(arena.getStaticObjectList().isEmpty());
    }
}
