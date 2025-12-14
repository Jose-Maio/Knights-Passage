package controller.managers;

import model.Direction;
import model.Position;
import model.entities.Entity;
import model.entities.characters.Character;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Object;
import model.game.level.Level;

import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class CollisionManager {

    //Get Side Entity1 is hitting Entity2

    public Direction getCollisionSide(Character attacker, Character target) {
        Rectangle attackRange = attacker.getAttackRange();
        Rectangle targetHitbox = target.getHitbox();

        if (!attackRange.intersects(targetHitbox)) {
            return null;
        }

        double rightOverlap = attackRange.getMaxX() - targetHitbox.getMinX();
        double leftOverlap = targetHitbox.getMaxX() - attackRange.getMinX();
        double bottomOverlap = attackRange.getMaxY() - targetHitbox.getMinY();
        double topOverlap = targetHitbox.getMaxY() - attackRange.getMinY();

        double minOverlap = min(min(leftOverlap, rightOverlap), min(topOverlap, bottomOverlap));


        if (minOverlap == leftOverlap) {
            return Direction.LEFT;
        } else if (minOverlap == rightOverlap) {
            return Direction.RIGHT;
        } else if (minOverlap == topOverlap) {
            return Direction.UP;
        } else if (minOverlap == bottomOverlap) {
            return Direction.DOWN;
        }

        return null;
    }

    public boolean checkPlayerCollisions(Position position , Level level) {
        Rectangle newHitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);

        for (Object object : level.getArena().getAllObjectList()) {
            if (object.isSolid() && newHitbox.intersects(object.getHitbox())) {
                return true;
            }
        }

        for (Enemy enemy : level.getCloseEnemyList()) {
            if (enemy.getHitbox().intersects(newHitbox)) {
                return true;
            }
        }

        //Check inside Arena
        if (!level.getArena().isInsideArena(newHitbox)) {
            return true;
        }

        return false;


    }
    public boolean checkEnemyCollisions(Position position, Enemy enemy,  Level level) {
        Rectangle newHitbox = new Rectangle(position.getX() + 2, position.getY() + 2, enemy.getHitbox().width, enemy.getHitbox().height);
        // Collisions with Arena Objects
        for (Object object : level.getArena().getAllObjectList()) {
            if (object.isSolid() && object.getHitbox().intersects(newHitbox)) {
                return true;
            }
        }


         // Collisions with other enemies
        for(Enemy other_enemy : level.getEnemyList()){
            if(newHitbox.intersects(other_enemy.getHitbox()) && enemy != other_enemy){
                return true;
            }
        }

        //Collisions with player
        if(newHitbox.intersects(level.getPlayer().getHitbox())){
            return true;
        }

        //Check insideArena
        return !level.getArena().isInsideArena(newHitbox);

    }

}
