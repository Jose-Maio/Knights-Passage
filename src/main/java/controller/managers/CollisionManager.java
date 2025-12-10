package controller.managers;

import model.Direction;
import model.Position;
import model.entities.Entity;
import model.entities.characters.enemies.Enemy;
import model.entities.objects.Object;
import model.game.Level;

import java.awt.*;

import static java.lang.Math.abs;

public class CollisionManager {

    //Get Side Entity1 is hitting Entity2
    public Direction getCollisionSide(Entity entity1, Entity entity2){
        Rectangle entity1H = new Rectangle(entity1.getPosition().getX() - 1, entity1.getPosition().getY() - 1, entity1.getHitbox().width + 2, entity1.getHitbox().height +2);
        Rectangle entity2H = new Rectangle(entity2.getPosition().getX() - 1, entity2.getPosition().getY() - 1, entity2.getHitbox().width + 2, entity2.getHitbox().height +2);

        if(entity1H.intersects(entity2H)){
            Position entity1Position = entity1.getPosition();
            Position entity2Position = entity2.getPosition();
            int distX = entity1Position.getX() - entity2Position.getX();
            int distY = entity1Position.getY() - entity2Position.getY();

            if(abs(distX) < abs(distY)){
                return distY < 0 ? Direction.DOWN : Direction.UP;
            }
            else{
                return distX < 0 ? Direction.RIGHT : Direction.LEFT;
            }
        }
        return null;
    }

    public boolean checkPlayerCollisions(Position position , Level level) {
        Rectangle newHitbox = new Rectangle(position.getX() + 2, position.getY() + 2, 12, 12);

        for (Object object : level.getArena().getObjectList()) {
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
