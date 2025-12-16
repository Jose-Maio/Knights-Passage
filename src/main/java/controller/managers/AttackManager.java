package controller.managers;


import model.Direction;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.level.Level;


public class AttackManager {
    private final CollisionManager collisionManager = new CollisionManager();

    public void playerAttack(Level level){
        Player player = level.getPlayer();
        if (!player.isAttacking()) return;


        for(Enemy enemy : level.getCloseEnemyList()){
            Direction collideDir = collisionManager.getCollisionSide(player, enemy);
            if((collideDir != null) && (collideDir == player.getFacing())){
                player.attack(enemy);
                break;
            }
        }

        player.lastAttack = System.currentTimeMillis();

    }

    public void enemyAttack(Level level){
        Player player = level.getPlayer();

        for(Enemy enemy : level.getCloseEnemyList()){
            enemy.setAttacking(false);
            Direction collideDir = collisionManager.getCollisionSide(enemy, player);
            if((collideDir != null) && (collideDir == enemy.getFacing()) && enemy.canAttack()){
                enemy.attack(player);

            }
        }
    }
}
