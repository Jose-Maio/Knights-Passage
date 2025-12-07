package view;

import gui.Gui;
import model.entities.characters.enemies.Enemy;
import model.game.Level;

import java.io.IOException;


public class LevelRenderer {
    CharacterRenderer characterRenderer = new CharacterRenderer();
    ArenaRenderer arenaRenderer = new ArenaRenderer();



    public LevelRenderer() throws IOException {
    }

    public void render(Level level, Gui gui) throws IOException {

        arenaRenderer.render(level.getArena(), gui);

        characterRenderer.render(level.getPlayer(), gui);

        for(Enemy enemy : level.getEnemyList()){
            characterRenderer.render(enemy,gui);

    }
    }
}
