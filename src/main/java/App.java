import model.Position;
import model.entities.characters.Player;
import model.game.Game;
import view.GameView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GameView g = new GameView();
        Player p = new Player(new Position(10,10),10, 10);
        Game game = new Game(1, p, List.of());
        g.render(game);
    }
}
