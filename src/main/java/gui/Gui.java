package gui;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import model.Direction;
import model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;

public interface Gui {
    void drawImage(String img,  Position position) throws IOException;

    void clear();

    void refresh() throws IOException;

    void drawImageToBuffer(String img, int xOffset, int yOffset, BufferedImage buffer) throws IOException;

    void drawBuffer(BufferedImage buffer) throws IOException;

    int getHeight();

    int getWidth();

    Screen getScreen();


    Set<Integer> getActiveKeys();

    KeyStroke step() throws IOException;
}
