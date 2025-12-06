package controller;

import model.Position;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Object;
import model.game.Arena;
import model.game.Level;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionManager {




    public boolean checkPlayerCollisions(Position position , Level level) {
        Rectangle newHitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);

        for (Object object : level.getArena().getObjectList()) {
            if (object.isSolid() && newHitbox.intersects(object.getHitbox())) {
                return true;
            }
        }

        for (Enemy enemy : level.getEnemyList()) {
            if (enemy.getHitbox().intersects(newHitbox)) {
                return true;
            }
        }

        //Check inside Arena
        if (!level.getArena().isInsideArena(newHitbox)) {
            System.out.println("Outside arena");
            return true;
        }

        return false;


    }
    public boolean checkEnemyCollisions(Position position, Enemy enemy,  Level level) {
        Rectangle newHitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);
        // Collisions with Arena Objects
        for (Object object : level.getArena().getObjectList()) {
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
