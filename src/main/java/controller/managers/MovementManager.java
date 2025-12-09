package controller.managers;

import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Level;

import static java.lang.Math.abs;

public class MovementManager {
    private static final CollisionManager collisionManager = new CollisionManager();

    public static void moveEnemies(Level level) {
        for (Enemy enemy : level.getCloseEnemyList()) {

            Direction nextDir = calculateNextEnemyMove(enemy,level.getPlayer());
            Position next = enemy.nextPos(nextDir);
            if(!collisionManager.checkEnemyCollisions(next, enemy, level)){
                enemy.move(nextDir);

            }
            else enemy.setFacing(nextDir);
        }
    }

    private static Direction calculateNextEnemyMove(Enemy enemy, Player player) {
        Position ePos = enemy.getPosition();
        Position pPos = player.getPosition();
        int distX = pPos.getX() - ePos.getX();
        int distY = pPos.getY() - ePos.getY();

        if (abs(distX) > abs(distY)) {
            return distX > 0 ? Direction.RIGHT : Direction.LEFT;
        } else {
            return distY > 0 ? Direction.DOWN : Direction.UP;
        }

    }

    public static void movePlayer(Level level, Direction direction){
        if (direction == null) return;
        Player player = level.getPlayer();
        Position next = player.nextPos(direction);
        if(!collisionManager.checkPlayerCollisions(next, level)){
            player.move(direction);
        }
        else {player.setFacing(direction);}

    }

}

