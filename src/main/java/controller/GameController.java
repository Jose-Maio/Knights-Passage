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

public class GameController {
    private Game game;
    private final MovementManager movementManager;
    private final GameView gameView;
    private long lastEnemyMove = 0;
    private final long enemyDelay = 300;

    public GameController(Game game) throws Exception {
        this.game = game;
        this.movementManager = new MovementManager();
        this.gameView = new GameView();
    }


    public void start() throws IOException {

        Gui gui = gameView.getGui();
        while(!game.isGameOver()){
            gui.step();
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
        return gameView.getGui().step();
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

        if (now - lastEnemyMove >= enemyDelay) {
            movementManager.moveEnemies(level);
            lastEnemyMove = now;
        }

        if (level.isComplete()) {
            game.nextLevel();
        }

        }
    }


