package model.game;

import model.Position;
import model.entities.objects.Object;

import java.awt.*;
import java.util.List;

public class Arena {
    private final List<Object> objectList;
    private final String backgroundImg;
    private final Rectangle dimensions;

    public Arena(List<Object> objects, String backgroundImg, Rectangle dimensions){
        this.objectList = objects;
        this.backgroundImg = backgroundImg;
        this.dimensions = dimensions;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public boolean isBlocked(Position position){
        for(Object object : objectList){
            if(object.getPosition().equals(position) && object.isSolid()) return true;
        }
        return false;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public Rectangle getDimensions() {
        return dimensions;
    }

    public boolean isInsideArena(Rectangle hitbox) {
        int left   = hitbox.x;
        int top    = hitbox.y;
        int right  = hitbox.x + hitbox.width;
        int bottom = hitbox.y + hitbox.height;

        int arenaLeft   = dimensions.x;
        int arenaTop    = dimensions.y;
        int arenaRight  = dimensions.x + dimensions.width;
        int arenaBottom = dimensions.y + dimensions.height;

        return left >= arenaLeft &&
                top >= arenaTop &&
                right <= arenaRight &&
                bottom <= arenaBottom;
    }
}