package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import model.game.Level;
import view.entities.EnemyRenderer;
import view.entities.PlayerRenderer;

import java.io.IOException;

public class LevelRenderer {
    public void render(Level level, TextGraphics graphics) throws IOException {
        PlayerRenderer pr = new PlayerRenderer();
        EnemyRenderer er = new EnemyRenderer();
        ArenaRenderer ar = new ArenaRenderer();


    }
}
