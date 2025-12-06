package model.game;

import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.entities.characters.enemies.ForestEnemy;
import model.entities.objects.Key;
import model.entities.objects.Object;
import model.entities.objects.Tree;
import model.game.config.GameConfiguration;

import java.awt.*;
import java.util.ArrayList;
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
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new ForestEnemy(new Position(25,55), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(295, 30), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(170,104), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));
        enemies.add(new ForestEnemy(new Position(350, 130), (int) (50 * configuration.getEnemyHealthMultiplier()), (int) (10 * configuration.getEnemyDamageMultiplier())));

        Key level1Key = new Key(new Position(40,20));
        Position entryPosition = new Position(100,100);
        Position exitPosition = new Position(390,200);
        Player p = new Player(10,10);
        return new Level(enemies, level1Key, createArena1(), entryPosition, exitPosition,p );
    }

    public Arena createArena1(){
        List<Object> objects = List.of(
                new Tree(new Position(40, 20)),
                new Tree(new Position(160,70 )),
                new Tree(new Position(320, 98))
        );
        return new Arena(objects, "sprites/forestbg.png", new Rectangle(0,0,400,208));
    }

    public List<Level> getLevels(){
        return List.of(
                createLevel1()
        );
    }
}
