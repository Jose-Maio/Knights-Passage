package controller;

import com.googlecode.lanterna.input.KeyStroke;
import gui.Gui;
import gui.LanternaGui;
import model.Direction;
import model.game.Game;
import model.game.Level;
import view.GameView;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import static com.googlecode.lanterna.input.KeyType.*;

public class GameController {
    private final Game game;
    private final GameView gameView;
    private long lastEnemyMove = 0;
    private final Gui gui;

    public GameController(Game game, Gui gui) throws Exception {
        this.game = game;
        this.gameView = new GameView(gui);
        this.gui = gui;
    }


    public void start() throws IOException {

        while(!game.isGameOver()){

            gameView.render(game);

            update();

           /*try {
                Thread.sleep(50); // ~20 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
        gui.getScreen().close();
    }

    public Direction handleInput() throws IOException {
        KeyStroke keystroke = gameView.getGui().step();
        if (keystroke == null) return null;

        return switch (keystroke.getKeyType()) {
            case ArrowUp -> Direction.UP;
            case ArrowDown -> Direction.DOWN;
            case ArrowLeft -> Direction.LEFT;
            case ArrowRight -> Direction.RIGHT;
            default -> null;
        };
    }


    public void update() throws IOException {
        long now = System.currentTimeMillis();
        Direction pressed = handleInput();
        Level level = game.getCurrentLevel();

        if (level.getPlayer().isDead()) {
            game.setGameOver();
        }

        movementManager.movePlayer(level, pressed);
        if(level.getArena().getKey() != null && level.getPlayer().getHitbox().intersects(level.getArena().getKey().getHitbox())) {
            level.getArena().pickKey();
            level.getPlayer().pickUpKey();

        }

        long enemyDelay = 300;
        if (now - lastEnemyMove >= enemyDelay) {
            MovementManager.moveEnemies(level);
            lastEnemyMove = now;
        }

        if (level.isComplete()) {
            game.nextLevel();
        }

        }
    }


