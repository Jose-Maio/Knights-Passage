package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import model.Direction;
import model.Position;
import model.game.config.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class LanternaGui implements Gui {
    private final Screen screen;
    private final TextGraphics graphics;
    private final int width;
    private final int height;
    private final Set<Integer> activeKeys = new HashSet<>();

    private final Map<String, BufferedImage> imageCache;

    public LanternaGui() throws IOException, FontFormatException, URISyntaxException {

        this.imageCache = new HashMap<>();

        DefaultTerminalFactory factory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT))
                .setTerminalEmulatorFontConfiguration(createFont())
                .setForceAWTOverSwing(true);

        Terminal terminal = factory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.startScreen();
        graphics = screen.newTextGraphics();

        this.width = GameConstants.GAME_WIDTH;
        this.height = GameConstants.GAME_HEIGHT;

        if (terminal instanceof AWTTerminalFrame terminalFrame) {
            terminalFrame.getComponent(0).addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    activeKeys.add(e.getKeyCode());
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    activeKeys.remove(e.getKeyCode());
                }
            });

            terminalFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        screen.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        } else {
            System.err.println("Warning: Terminal is not a graphical frame, KeyListener may not work as expected.");
        }
    }

    public LanternaGui(Screen screen, TextGraphics graphics, int width, int height) {
        //Constructor for testing
        this.screen = screen;
        this.graphics = graphics;
        this.width = width;
        this.height = height;
        this.imageCache = new HashMap<>();

    }



    private AWTTerminalFontConfiguration createFont() throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;

        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 4);

        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(newfont);

        return fontConfig;
    }

    private BufferedImage loadImage(String path) throws IOException {
        if (imageCache.containsKey(path)) {
            return imageCache.get(path);
        }

        try {
            BufferedImage image = ImageIO.read(
                    Objects.requireNonNull(
                            getClass().getClassLoader().getResourceAsStream(path)));

            imageCache.put(path, image);

            return image;

        } catch (IOException e) {
            System.err.println("Failed to load image: " + path);
            throw e;
        }
    }

    @Override
    public void drawImage(String img, Position position) throws IOException {

        BufferedImage sprite = loadImage(img);

        for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0) {
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue),
                            new TextColor.RGB(red, green, blue));
                    graphics.setCharacter(position.getX() + x, position.getY() + y, c);
                }

            }
        }
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void drawImageToBuffer(String img, int xOffset, int yOffset, BufferedImage buffer) throws IOException {
        BufferedImage sprite = loadImage(img);

        for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int rgb = sprite.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                if (alpha != 0) {
                    int destX = x + xOffset;
                    int destY = y + yOffset;
                    if (destX >= 0 && destX < buffer.getWidth() && destY >= 0 && destY < buffer.getHeight()) {
                        buffer.setRGB(destX, destY, rgb);
                    }
                }
            }
        }
    }

    public void drawBuffer(BufferedImage buffer) {
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

    public KeyStroke step() throws IOException {
        return screen.pollInput();

    }

    @Override
    public Set<Integer> getActiveKeys() {
        return activeKeys;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    @Override
    public void clearInput() throws IOException {
        KeyStroke key;
        do {
            key = screen.pollInput();
        } while (key != null);
    }
}
