package controller;

import model.Direction;
import model.Position;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Level;

import static java.lang.Math.abs;

public class MovementManager {

    public void moveEnemies(Level level) {
        for (Enemy enemy : level.getCloseEnemyList()) {

            Position next = calculateNextEnemyMove(enemy, level.getPlayer());
            if(!CollisionManager.checkEnemyCollisions(next, enemy, level)){
                enemy.setPosition(next);

            }
        }
    }

    private Position calculateNextEnemyMove(Enemy enemy, Player player) {
        Position ePos = enemy.getPosition();
        Position pPos = player.getPosition();
        int distX = pPos.getX() - ePos.getX();
        int distY = pPos.getY() - ePos.getY();
        int stepX = 0;
        int stepY = 0;

        if (abs(distX) > abs(distY)) {
            stepX = distX > 0 ? 1 : -1;
        } else {
            stepY = distY > 0 ? 1 : -1;
        }
        return new Position(ePos.getX() + stepX, ePos.getY() + stepY);
    }

    public void movePlayer(Level level, Direction direction){
        if (direction == null) return;
        Player player = level.getPlayer();
        Position next = player.nextPos(direction);
        if(!CollisionManager.checkPlayerCollisions(next, level)){
            player.move(direction);
        }

    }

}

