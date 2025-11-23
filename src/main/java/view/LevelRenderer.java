package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.entities.characters.enemies.Enemy;
import model.game.Level;
import view.entities.EnemyRenderer;
import view.entities.KeyRenderer;
import view.entities.PlayerRenderer;

import java.io.IOException;


public class LevelRenderer {
    public void render(Level level, TextGraphics graphics) throws IOException {
        PlayerRenderer pr = new PlayerRenderer();
        EnemyRenderer er = new EnemyRenderer();
        ArenaRenderer ar = new ArenaRenderer();
        KeyRenderer kr = new KeyRenderer();

        ar.render(level.getArena(), graphics);

        pr.render(level.getPlayer(), graphics);

        kr.render(level.getKey(), graphics);

        for(Enemy enemy : level.getEnemyList()){
            er.render(enemy, graphics);
        }


    }
}
