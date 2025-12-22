package controller;


import controller.menu.GameOverMenuController;
import gui.Gui;
import model.Direction;
import model.game.Game;
import model.game.level.Level;
import model.game.menu.GameOverMenu;
import view.GameView;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;

public class GameController {
    private final Game game;
    private final GameView gameView;
    private final Gui gui;
    private final LevelController levelController;

    long last = System.currentTimeMillis(); //Calculate FPS
    int frames = 0;

    public GameController(Game game, Gui gui) throws Exception {
        this.game = game;
        this.gameView = new GameView(gui);
        this.gui = gui;
        this.levelController = new LevelController();
    }

    public void start() throws Exception {

        while(!game.isGameOver()){

            if (gui.getActiveKeys().contains(KeyEvent.VK_Q)) {
                gui.getScreen().close();
                return;
            }

            gameView.render(game);

            levelController.update(game.getCurrentLevel(), handleMovInput(), isAttackPressed());

            update();

           try {
                Thread.sleep(25); // ~20 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            frames++;
            long now = System.currentTimeMillis();
            if (now - last >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                last = now;
            }

        }
        GameOverMenu gameOverMenu = new GameOverMenu(game);
        gameOverMenu.resetSelection();
        GameOverMenuController gameOverMenuController = new GameOverMenuController(gameOverMenu, gui);
        gui.clearInput();
        gameOverMenuController.start();
    }

    public HashSet<Direction> handleMovInput() {
        HashSet<Direction> directions = new HashSet<>();

        for(int k : gui.getActiveKeys()){
            if (k == KeyEvent.VK_UP) directions.add(Direction.UP);
            if (k == KeyEvent.VK_DOWN) directions.add(Direction.DOWN);
            if (k == KeyEvent.VK_LEFT) directions.add(Direction.LEFT);
            if (k == KeyEvent.VK_RIGHT) directions.add(Direction.RIGHT);
        }

        return directions;
    }

    public boolean isAttackPressed(){
        return gui.getActiveKeys().contains(KeyEvent.VK_E);
    }


    public void update() throws IOException {

        Level level = game.getCurrentLevel();

        if (level.getPlayer().isDead()) {
            game.setGameOver();
        }


        if (level.isComplete()) {
            game.nextLevel();
            levelController.setHasSpawnedPlayer(false);

        }
        }
    }
