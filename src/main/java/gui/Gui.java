package gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.Position;

import java.awt.image.BufferedImage;

public interface Gui {
     public void drawImage(BufferedImage sprite,  Position position);


}
