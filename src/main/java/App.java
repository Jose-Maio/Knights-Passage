import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.characters.Player;
import model.entities.objects.Key;
import model.entities.objects.Wall;
import model.game.Arena;
import model.game.Game;
import model.game.Level;
import model.game.config.Difficulty;
import model.game.config.GameConfiguration;
import view.GameView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GameView g = new GameView();

        Game game = new Game(new GameConfiguration(Difficulty.MEDIUM));
        g.render(game);
    }
}