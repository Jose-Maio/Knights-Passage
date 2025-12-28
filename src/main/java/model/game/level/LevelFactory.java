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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelFactory {

    private final GameConfiguration configuration;

    public LevelFactory(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    private void parseLevelStrings(List<String> layout, List<Enemy> enemies, List<Object> staticObjects,
            List<Object> dynamicObjects) {
        for (int y = 0; y < layout.size(); y++) {
            String row = layout.get(y);
            for (int x = 0; x < row.length(); x++) {
                char c = row.charAt(x);
                Position pos = new Position(x * 16, y * 16);
                switch (c) {
                    // Objects
                    case 'T' -> staticObjects.add(new Tree(pos));
                    case 'K' -> dynamicObjects.add(new Key(pos));
                    // Walls
                    case 'h' -> staticObjects.add(new SmallWallH(pos));
                    case 'H' -> staticObjects.add(new BigWallH(pos));
                    case 'v' -> staticObjects.add(new SmallWallV(pos));
                    case 'V' -> staticObjects.add(new BigWallV(pos));
                    // Enemies
                    case 'F' -> enemies.add(new ForestEnemy(pos, (int) (50 * configuration.getEnemyHealthMultiplier()),
                            (int) (10 * configuration.getEnemyDamageMultiplier())));
                    case 'D' -> enemies.add(new DungeonEnemy(pos, (int) (50 * configuration.getEnemyHealthMultiplier()),
                            (int) (10 * configuration.getEnemyDamageMultiplier())));
                    case 'C' -> enemies.add(new CastleEnemy(pos, (int) (50 * configuration.getEnemyHealthMultiplier()),
                            (int) (10 * configuration.getEnemyDamageMultiplier())));
                    case 'B' -> enemies.add(new Boss(pos, (int) (200 * configuration.getEnemyHealthMultiplier()),
                            (int) (20 * configuration.getEnemyDamageMultiplier())));
                    // Intersecting Walls (Corners)
                    // X: Top-Left (Down, Right)
                    case 'X' -> {
                        staticObjects.add(new BigWallV(pos));
                        staticObjects.add(new BigWallH(pos));
                    }
                    // Y: Top-Right (Down, Left)
                    case 'Y' -> {
                        staticObjects.add(new BigWallV(pos));
                        staticObjects.add(new BigWallH(new Position(pos.getX() - 43, pos.getY())));
                    }
                    // Z: Bottom-Left (Up, Right)
                    case 'Z' -> {
                        staticObjects.add(new BigWallV(new Position(pos.getX(), pos.getY() - 43)));
                        staticObjects.add(new BigWallH(pos));
                    }
                    // Q: Bottom-Right (Up, Left)
                    case 'Q' -> {
                        staticObjects.add(new BigWallV(new Position(pos.getX(), pos.getY() - 43)));
                        staticObjects.add(new BigWallH(new Position(pos.getX() - 43, pos.getY())));
                    }
                    // Dynamic Corners (lowercase)
                    // x: Dynamic Top-Left
                    case 'x' -> {
                        dynamicObjects.add(new BigWallV(pos));
                        dynamicObjects.add(new BigWallH(pos));
                    }
                    // y: Dynamic Top-Right
                    case 'y' -> {
                        dynamicObjects.add(new BigWallV(pos));
                        dynamicObjects.add(new BigWallH(new Position(pos.getX() - 43, pos.getY())));
                    }
                    // z: Dynamic Bottom-Left
                    case 'z' -> {
                        dynamicObjects.add(new BigWallV(new Position(pos.getX(), pos.getY() - 43)));
                        dynamicObjects.add(new BigWallH(pos));
                    }
                    // q: Dynamic Bottom-Right
                    case 'q' -> {
                        dynamicObjects.add(new BigWallV(new Position(pos.getX(), pos.getY() - 43)));
                        dynamicObjects.add(new BigWallH(new Position(pos.getX() - 43, pos.getY())));
                    }
                }
            }
        }
    }

    public Level createLevel1(Player player) {
        List<String> layout = loadLevel("level1.txt");

        List<Enemy> enemies = new ArrayList<>();
        List<Object> staticObjects = new ArrayList<>();
        List<Object> dynamicObjects = new ArrayList<>();

        parseLevelStrings(layout, enemies, staticObjects, dynamicObjects);

        Position entryPosition = new Position(0, 144);
        Rectangle exitPosition = new Rectangle(252, 144, 4, 16);
        return new Level(enemies,
                new Arena(staticObjects, dynamicObjects, "sprites/backgrounds/forestbg.png",
                        new Rectangle(0, 0, 256, 160)),
                entryPosition, exitPosition, player, new KeyCollectedRule(), null);
    }

    public Level createLevel2(Player player) {

        List<String> layout = loadLevel("level2.txt");

        List<Enemy> enemies = new ArrayList<>();
        List<Object> staticObjects = new ArrayList<>();
        List<Object> dynamicObjects = new ArrayList<>();

        parseLevelStrings(layout, enemies, staticObjects, dynamicObjects);

        Position entryPosition = new Position(0, 144);
        Rectangle exitPosition = new Rectangle(252, 0, 4, 16);
        return new Level(enemies,
                new Arena(staticObjects, dynamicObjects, "sprites/backgrounds/dungeonbg.png",
                        new Rectangle(0, 0, 256, 160)),
                entryPosition, exitPosition, player, new KeyCollectedRule(), new RemoveObject());
    }

    public Level createLevel3(Player player) {
        List<String> layout = loadLevel("level3.txt");

        List<Enemy> enemies = new ArrayList<>();
        List<Object> staticObjects = new ArrayList<>();
        List<Object> dynamicObjects = new ArrayList<>();

        parseLevelStrings(layout, enemies, staticObjects, dynamicObjects);

        Position entryPosition = new Position(1, 71);
        Rectangle exitPosition = new Rectangle(253, 68, 4, 25);
        Key key = new Key(new Position(30, 75));
        return new Level(enemies,
                new Arena(staticObjects, dynamicObjects, "sprites/backgrounds/castlebg.png",
                        new Rectangle(0, 0, 256, 160)),
                entryPosition, exitPosition, player, new KeyCollectedRule(), new EnemiesDropKey(key));
    }

    public Level createLevel4(Player player) {
        List<String> layout = loadLevel("level4.txt");

        List<Enemy> enemies = new ArrayList<>();
        List<Object> staticObjects = new ArrayList<>();
        List<Object> dynamicObjects = new ArrayList<>();

        parseLevelStrings(layout, enemies, staticObjects, dynamicObjects);

        Position entryPosition = new Position(1, 71);
        Rectangle exitPosition = new Rectangle(234, 51, 15, 61);
        return new Level(enemies,
                new Arena(staticObjects, dynamicObjects, "sprites/backgrounds/bossroombg.png",
                        new Rectangle(0, 0, 256, 160)),
                entryPosition, exitPosition, player, new AllEnemiesDeadRule(), null);
    }

    public List<Level> getLevels(Player player) {
        return List.of(
                createLevel1(player),
                createLevel2(player),
                createLevel3(player),
                createLevel4(player));
    }

    private List<String> loadLevel(String filename) {
        List<String> lines = new ArrayList<>();
        URL resource = getClass().getClassLoader().getResource("levels/" + filename);
        if (resource == null) {
            System.err.println("Level file not found: " + filename);
            return lines;
        }

        try (InputStream is = resource.openStream();
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
