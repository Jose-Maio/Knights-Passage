package view;

import gui.LanternaGui;
import model.entities.characters.enemies.Enemy;
import model.entities.characters.enemies.ForestEnemy;
import model.game.Level;
import view.entities.ForestEnemyRenderer;
import view.entities.KeyRenderer;
import view.entities.PlayerRenderer;

import java.io.IOException;


public class LevelRenderer {
    public void render(Level level, LanternaGui gui) throws IOException {
        PlayerRenderer pr = new PlayerRenderer();
        ForestEnemyRenderer fer = new ForestEnemyRenderer();
        ArenaRenderer ar = new ArenaRenderer();
        KeyRenderer kr = new KeyRenderer();

        ar.render(level.getArena(), gui);

        pr.render(level.getPlayer(), gui);

        kr.render(level.getKey(), gui);

        for(Enemy enemy : level.getEnemyList()){
            if(ForestEnemy.class == enemy.getClass()){
            fer.render((ForestEnemy) enemy, gui);
        }


    }
        }
}
