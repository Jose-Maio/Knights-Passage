package view;

import gui.LanternaGui;
import model.entities.characters.enemies.Enemy;
import model.game.Level;
import view.entities.EnemyRenderer;
import view.entities.KeyRenderer;
import view.entities.PlayerRenderer;

import java.io.IOException;


public class LevelRenderer {
    public void render(Level level, LanternaGui gui) throws IOException {
        PlayerRenderer pr = new PlayerRenderer();
        EnemyRenderer er = new EnemyRenderer();
        ArenaRenderer ar = new ArenaRenderer();
        KeyRenderer kr = new KeyRenderer();

        ar.render(level.getArena(), gui);

        pr.render(level.getPlayer(), gui);

        kr.render(level.getKey(), gui);

        for(Enemy enemy : level.getEnemyList()){
            er.render(enemy, gui);
        }


    }
}
