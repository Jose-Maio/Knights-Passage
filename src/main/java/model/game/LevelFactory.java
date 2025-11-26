package model.game;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.game.config.GameConfiguration;

import java.util.List;

public class LevelFactory {
    private static LevelFactory instance;
    private final GameConfiguration configuration;

    private LevelFactory(GameConfiguration configuration){
        this.configuration = configuration;
    }

    public static LevelFactory getInstance(GameConfiguration configuration) {
        if(instance == null){
            instance = new LevelFactory(configuration);
        }
        return instance;
    }

    public Level createLevel1(){
        List<ForestEnemy> enemies = List.of(
                new ForestEnemy(new Position(25,25), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())),
                new ForestEnemy(new Position(200,104), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())),
                new ForestEnemy(new Position(320, 30), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())),
                new ForestEnemy(new Position(384, 98), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier()))

        );
        Key level1Key = new Key(new Position(40,20));
        Position entryPosition = new Position(0,192);
        Position exitPosition = new Position(390,200);
        Player p = new Player(10,10);
        return new Level(enemies, level1Key, createArena1(), entryPosition, exitPosition,p );
    }

    public Arena createArena1(){
        List<? extends Object> objects = List.of(
                new Tree(new Position(40, 20)),
                new Tree(new Position(110,30 )),
                new Tree(new Position(320, 98))
        );
        return new Arena(objects, "ola");
    }

    public List<Level> getLevels(){
        return List.of(
                createLevel1()
        );
    }
}
