package view.entities;


import gui.Gui;
import model.entities.characters.Character;
import java.awt.*;
import java.io.IOException;

public class CharacterRenderer implements EntityRenderer<Character> {


    @Override
    public String getImgPath(Character character) {
        return "sprites/characters/" + character.toStringImg() + ".png";
    }

    @Override
    public void render(Character character, Gui gui) throws IOException {
        gui.drawImage(getImgPath(character), character.getPosition());
    }
}

