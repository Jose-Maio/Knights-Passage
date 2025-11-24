import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.characters.Player;
import model.entities.objects.Key;
import model.entities.objects.Wall;
import model.game.Arena;
import model.game.Game;
import model.game.Level;
import view.GameView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GameView g = new GameView();
        Player p = new Player(new Position(0,0),10, 10);
        Key k = new Key(new Position(200,200));

        Level l = new Level(List.of(), k, new Arena(List.of(
                new Wall(new Position(0,0)),
                new Wall(new Position(0,16)),
                new Wall(new Position(0,32)),
                new Wall(new Position(0,48)),
                new Wall(new Position(0,64)),
                new Wall(new Position(0,80)),
                new Wall(new Position(0,96)),
                new Wall(new Position(0,112)),
                new Wall(new Position(0,128)),
                new Wall(new Position(0,144))), new TextColor.RGB(200, 200, 200)), new Position(0,0),new Position(100,100),p);
        List<Level> levels = List.of(
                l
        );

        Game game = new Game(0, p, levels );
        g.render(game);
    }
}
