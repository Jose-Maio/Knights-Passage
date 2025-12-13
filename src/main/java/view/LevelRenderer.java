package view;

import gui.Gui;
import model.entities.characters.HealthBar;
import model.entities.characters.enemies.Enemy;
import model.game.level.Level;
import view.entities.CharacterRenderer;

import java.io.IOException;


public class LevelRenderer {
    CharacterRenderer characterRenderer = new CharacterRenderer();
    ArenaRenderer arenaRenderer = new ArenaRenderer();
    HealthBarRenderer healthBarRenderer = new HealthBarRenderer();

    private Level prevLevel = null;

    public LevelRenderer() {
    }

    public void render(Level level, Gui gui) throws IOException {

        if(prevLevel != level && prevLevel != null){
            arenaRenderer.resetArenaBuffer();
        }

        prevLevel = level;
        
        arenaRenderer.render(level.getArena(), gui);

        characterRenderer.render(level.getPlayer(), gui);
        healthBarRenderer.render(new HealthBar(level.getPlayer()),gui);

        for(Enemy enemy : level.getEnemyList()){
            characterRenderer.render(enemy,gui);
            healthBarRenderer.render(new HealthBar(enemy), gui);

    }
    }
}
