package view;

import gui.Gui;
import model.entities.characters.Character;
import model.entities.characters.HealthBar;

import java.io.IOException;

public class HealthBarRenderer {



    public void render(HealthBar bar, Gui gui) throws IOException {
        gui.drawImage(bar.toStringImg(), bar.getPosition());}
}
