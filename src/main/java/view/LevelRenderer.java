package view;

import gui.Gui;
import model.entities.characters.enemies.Enemy;
import model.game.Level;
import view.entities.CharacterRenderer;

import java.io.IOException;


public class LevelRenderer {
    CharacterRenderer characterRenderer = new CharacterRenderer();
    ArenaRenderer arenaRenderer = new ArenaRenderer();



    public LevelRenderer() {
    }

    public void render(Level level, Gui gui) throws IOException {

        arenaRenderer.render(level.getArena(), gui);

        characterRenderer.render(level.getPlayer(), gui);

        for(Enemy enemy : level.getEnemyList()){
            characterRenderer.render(enemy,gui);

    }
    }
}
