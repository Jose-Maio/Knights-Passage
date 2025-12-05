package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import model.Position;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;


public class LanternaGui implements Gui {
    private final Screen screen;
    private final TextGraphics graphics;
    private final int width;
    private final int height;

    public LanternaGui() throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;

        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 3);

        AWTTerminalFontConfiguration fontConfig =
                AWTTerminalFontConfiguration.newInstance(newfont);

        screen = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(400, 208))
                .setTerminalEmulatorFontConfiguration(fontConfig)
                .setForceAWTOverSwing(true)
                .createScreen();

        screen.startScreen();
        graphics = screen.newTextGraphics();

        this.width = 400;
        this.height = 208;
    }

    @Override
    public void drawImage(String img, Position position) throws IOException {

        BufferedImage sprite = ImageIO.read(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResourceAsStream(img)
                )
        );
        for (int x = 0; x < sprite.getWidth(); x++){
            for (int y = 0; y < sprite.getHeight(); y++){
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0) {
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    graphics.setCharacter(position.getX() + x, position.getY() + y, c);
                }

            }
        }
    }

    public void clear(){
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void drawImageToBuffer(String img, int xOffset, int yOffset, BufferedImage buffer) throws IOException {
        BufferedImage sprite = ImageIO.read(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(img))
        );

        for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int rgb = sprite.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                if (alpha != 0) {
                    buffer.setRGB(x + xOffset, y + yOffset, rgb);
                }
            }
        }
    }

    public void drawBuffer(BufferedImage buffer)  {
        for (int x = 0; x < buffer.getWidth(); x++) {
            for (int y = 0; y < buffer.getHeight(); y++) {
                int rgb = buffer.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                if (alpha != 0) {
                    int red = (rgb >> 16) & 0xff;
                    int green = (rgb >> 8) & 0xff;
                    int blue = rgb & 0xff;

                    TextCharacter c = new TextCharacter(' ',
                            new com.googlecode.lanterna.TextColor.RGB(red, green, blue),
                            new com.googlecode.lanterna.TextColor.RGB(red, green, blue));

                    graphics.setCharacter(x, y, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Screen getScreen() {
        return screen;
    }
}
