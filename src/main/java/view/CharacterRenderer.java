package view;

import gui.Gui;
import model.entities.characters.Character;
import model.entities.objects.Object;
import view.entities.EntityRenderer;

import java.io.IOException;

public class CharacterRenderer extends EntityRenderer<Character> {


    @Override
    public String getImgPath(Character character) {
        return "sprites/" + character.toStringImg() + ".png";
    }

    @Override
    public void render(Character character, Gui gui) throws IOException {
        String path = getImgPath(character);
        System.out.println("Loading image: " + path);
        gui.drawImage(getImgPath(character), character.getPosition());
    }
}
