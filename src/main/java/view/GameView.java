package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import model.game.Game;
import view.entities.PlayerRenderer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameView {

    private final Screen screen;
    private final TextGraphics graphics;

    public GameView() throws Exception {

        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        assert resource != null;

        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 4);

        AWTTerminalFontConfiguration fontConfig =
                AWTTerminalFontConfiguration.newInstance(newfont);

        screen = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(1000, 400))
                .setTerminalEmulatorFontConfiguration(fontConfig)
                .setForceAWTOverSwing(true)
                .createScreen();

        screen.startScreen();
        graphics = screen.newTextGraphics();
    }

    public void render(Game game) throws IOException {
        screen.clear();

        PlayerRenderer pr = new PlayerRenderer();
        pr.render(game.getPlayer(), graphics);

        screen.refresh();
    }
}


