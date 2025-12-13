package model.game;

import model.Position;
import model.entities.objects.Key;
import model.entities.objects.Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final List<Object> staticObjectList;
    private final String backgroundImg;
    private final Rectangle dimensions;
    private final List<Object> dynamicObjectList;

    public Arena(List<Object> staticObjects, List<Object> dynamicObjects ,String backgroundImg, Rectangle dimensions){
        this.staticObjectList = new ArrayList<>(staticObjects);
        this.dynamicObjectList = new ArrayList<>(dynamicObjects);
        this.backgroundImg = backgroundImg;
        this.dimensions = dimensions;
    }

    public List<Object> getStaticObjectList() {
        return staticObjectList;
    }

    public List<Object> getDynamicObjectList() {
        return dynamicObjectList;
    }

    public List<Object> getAllObjectList() {
        List<Object> allObjects = new ArrayList<>();
        allObjects.addAll(staticObjectList);
        allObjects.addAll(dynamicObjectList);
        return allObjects;
    }

    public boolean isBlocked(Position position){
        for(Object object : getAllObjectList()){
            if(object.getPosition().equals(position) && object.isSolid()) return true;
        }
        return false;
    }

    public String getBackgroundImg() {
        return backgroundImg;
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

    public Key getKey(){
        for(Object object : dynamicObjectList){
            if(object instanceof Key){
                return (Key) object;
            }
        }
        return null;
    }

    public void placeKey(Key key){
        dynamicObjectList.add(key);
    }

    public void pickKey(){
        getKey().pick();
        dynamicObjectList.remove(getKey());

    }

    public Rectangle getDimensions() {
        return dimensions;
    }
}