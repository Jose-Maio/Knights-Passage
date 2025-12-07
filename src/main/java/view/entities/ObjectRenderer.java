package view.entities;

import gui.Gui;
import model.entities.objects.Object;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ObjectRenderer extends EntityRenderer<Object>{

    public String getImgPath(Object object){
        return "sprites/objects/" + object.toStringImg() + ".png";
    }
    @Override
    public void render(Object object, Gui gui) throws IOException {
        gui.drawImage(getImgPath(object), object.getPosition());

    }
    public void renderToBuffer(Object object, BufferedImage buffer, Gui gui) throws IOException {
        gui.drawImageToBuffer(getImgPath(object), object.getPosition().getX(), object.getPosition().getY(), buffer);
    }
}
