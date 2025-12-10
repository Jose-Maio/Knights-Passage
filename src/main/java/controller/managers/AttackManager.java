package controller.managers;


import model.Direction;
import model.entities.characters.Player;
import model.entities.characters.enemies.Enemy;
import model.game.Level;


public class AttackManager {
    private static final CollisionManager collisionManager = new CollisionManager();

    public static void playerAttack(Level level){
        Player player = level.getPlayer();
        for(Enemy enemy : level.getCloseEnemyList()){
            Direction collideDir = collisionManager.getCollisionSide(player, enemy);
            if((collideDir != null) && (collideDir == player.getFacing()) && player.isAttacking()){
                enemy.takeDamage(level.getPlayer().getAttackPower());
                break;
            }
        }

    }

    public static void enemyAttack(Level level){
        Player player = level.getPlayer();
        for(Enemy enemy : level.getCloseEnemyList()){
            enemy.setAttacking(false);
            Direction collideDir = collisionManager.getCollisionSide(enemy, player);
            if((collideDir != null) && (collideDir == enemy.getFacing())){
                player.takeDamage(enemy.getDamage());
                enemy.setAttacking(true);

            }
        }
    }
}
