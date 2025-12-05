package gui;


import com.googlecode.lanterna.screen.Screen;
import model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Gui {
    void drawImage(String img,  Position position) throws IOException;

    void clear();

    void refresh() throws IOException;

    void drawImageToBuffer(String img, int xOffset, int yOffset, BufferedImage buffer) throws IOException;

    void drawBuffer(BufferedImage buffer) throws IOException;

    int getHeight();

    int getWidth();

    Screen getScreen();
}
