package model.game;

import model.Position;
import model.entities.objects.Object;
import java.util.List;

public class Arena {
    private final List<Object> objectList;
    // private final background color

    Arena(List<Object> objects){
        this.objectList = objects;
    }

    boolean isBlocked(Position position){
        for(Object object : objectList){
            if(object.getPosition().equals(position)) return true;
        }
        return false;
    }

}
