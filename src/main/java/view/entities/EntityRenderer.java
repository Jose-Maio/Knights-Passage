package view.entities;

import gui.Gui;
import gui.LanternaGui;
import model.entities.Entity;
import model.entities.characters.enemies.Enemy;
import model.game.Game;

public interface EntityRenderer<T extends Entity, G extends Gui> {
    void render(T entity,G gui);

}
