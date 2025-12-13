package model.game.level;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.*;
import model.entities.objects.*;
import model.entities.objects.Object;
import model.game.Arena;
import model.game.config.GameConfiguration;
import model.game.level.CompletionRules.AllEnemiesDeadRule;
import model.game.level.CompletionRules.KeyCollectedRule;
import model.game.level.SpecialBehavior.EnemiesDropKey;
import model.game.level.SpecialBehavior.RemoveObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelFactory {
    private static LevelFactory instance;
    private final GameConfiguration configuration;



    private LevelFactory(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    public static LevelFactory getInstance(GameConfiguration configuration) {
        if (instance == null) {
            instance = new LevelFactory(configuration);
        }
        return instance;
    }

    public Level createLevel1(Player player) {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new ForestEnemy(new Position(25, 55), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(200, 30), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(170, 104), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(210, 100), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(25, 130), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));


        Position entryPosition = new Position(0,144);
        Rectangle exitPosition = new Rectangle(252, 144, 4,16);
        return new Level(enemies, createArena1(), entryPosition, exitPosition, player, new KeyCollectedRule() , null);
    }

    public Arena createArena1() {
        List<Object> staticObjects = List.of(
                new Tree(new Position(40, 20)),
                new Tree(new Position(160, 70)),
                new Tree(new Position(230, 98))

        );
        List<Object> dynamicObjects = List.of(
                new Key(new Position(200, 100))
        );
        return new Arena(staticObjects, dynamicObjects,"sprites/backgrounds/forestbg.png", new Rectangle(0, 0, 256, 160));
    }

    public Level createLevel2(Player player) {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new DungeonEnemy(new Position(7, 13), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new DungeonEnemy(new Position(110, 45), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new DungeonEnemy(new Position(55, 143), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new DungeonEnemy(new Position(238, 9), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new DungeonEnemy(new Position(198, 137), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));


        Position entryPosition = new Position(0, 144);
        Rectangle exitPosition = new Rectangle(252, 0, 4, 16);
        return new Level(enemies, createArena2(), entryPosition, exitPosition, player, new KeyCollectedRule(), new RemoveObject());
    }

    public Arena createArena2() {
        List<Object> staticObjects = List.of(
                new SmallWallH(new Position(0, 130)),
                new SmallWallH(new Position(15, 130)),
                new BigWallV(new Position(22, 78)),
                new BigWallV(new Position(22, 27)),
                new SmallWallH(new Position(15, 27)),
                new SmallWallH(new Position(0, 27)),
                new BigWallV(new Position(85, 109)),
                new BigWallV(new Position(85, 58)),
                new BigWallV(new Position(179, 58)),
                new BigWallV(new Position(179, 109)),
                new BigWallV(new Position(210, 0)),
                new BigWallV(new Position(210, 50)),
                new SmallWallV(new Position(85, 0)),
                new SmallWallV(new Position(85, 7)),
                new BigWallH(new Position(85, 14)),
                new BigWallH(new Position(136, 14)),
                new SmallWallV(new Position(179, 0)),
                new SmallWallV(new Position(179, 7))
        );
        List<Object> dynamicObjects = List.of(
                new BigWallH(new Position(85, 58)),
                new BigWallH(new Position(136, 58)),
                new Key(new Position(129, 120))
        );
        return new Arena(staticObjects, dynamicObjects,"sprites/backgrounds/dungeonbg.png", new Rectangle(0, 0, 256, 160));
    }

    public Level createLevel3(Player player) {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new CastleEnemy(new Position(210, 63), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new CastleEnemy(new Position(210, 85), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));


        Position entryPosition = new Position(1, 71);
        Rectangle exitPosition = new Rectangle(253, 68, 4, 25);
        Key key = new Key(new Position(30,75));
        return new Level(enemies, createArena3(), entryPosition, exitPosition, player , new KeyCollectedRule(), new EnemiesDropKey(key));
    }

    public Arena createArena3() {
        List<Object> staticObjects = List.of(
                new BigWallH(new Position(1, 110)),
                new BigWallH(new Position(51, 110)),
                new BigWallH(new Position(101, 110)),
                new BigWallH(new Position(151, 110)),
                new BigWallH(new Position(201, 110)),
                new BigWallH(new Position(205, 110)),
                new BigWallH(new Position(1, 41)),
                new BigWallH(new Position(51, 41)),
                new BigWallH(new Position(101, 41)),
                new BigWallH(new Position(151, 41)),
                new BigWallH(new Position(201, 41)),
                new BigWallH(new Position(205, 41))


        );

        List<Object> dynamicObjects = List.of(
        );

        return new Arena(staticObjects, dynamicObjects,"sprites/backgrounds/castlebg.png", new Rectangle(0, 0, 256, 160));
    }

    public Level createLevel4(Player player) {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Boss(new Position(160, 61), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));


        Position entryPosition = new Position(1, 71);
        Rectangle exitPosition = new Rectangle(234, 51, 15, 61);
        return new Level(enemies, createArena4(), entryPosition, exitPosition, player , new AllEnemiesDeadRule(), null);
    }

    public Arena createArena4() {
        List<Object> staticObjects = List.of();
        List<Object> dynamicObjects = List.of();
        return new Arena(staticObjects, dynamicObjects, "sprites/backgrounds/bossroombg.png", new Rectangle(0, 0, 256, 160));
    }

    public List<Level> getLevels(Player player) {
        return List.of(
                createLevel1(player),
                createLevel2(player),
                createLevel3(player),
                createLevel4(player)
        );
    }
};