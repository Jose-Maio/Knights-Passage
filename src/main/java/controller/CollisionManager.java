package controller;

import model.entities.characters.enemies.Enemy;
import model.entities.objects.Object;
import model.game.Arena;
import model.game.Level;

import java.awt.*;

public class CollisionManager {

    public static boolean checkCollision(Rectangle hitbox1, Rectangle hitbox2){
        return (hitbox1.intersects(hitbox2));
    }

    public boolean checkPlayerCollisions(Rectangle newHitbox , Level level){


        for(Object object : level.getArena().getObjectList()){
            if(object.isSolid() && object.getHitbox().intersects(newHitbox)){
                return true;
            }
        }

        for(Enemy enemy : level.getCloseEnemyList()){
            if(enemy.getHitbox().intersects(newHitbox)){
                return true;
            }
        }
        return false;

    }
}
