package model.game;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.objects.Object;
import java.util.List;

public class Arena {
    private final List<Object> objectList;
    private final String backgroundImg;;

    public Arena(List<Object> objects, String backgroundImg){
        this.objectList = objects;
        this.backgroundImg = backgroundImg;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public boolean isBlocked(Position position){
        for(Object object : objectList){
            if(object.getPosition().equals(position)) return true;
        }
        return false;
    }


    public String getBackgroundImg() {
        return backgroundImg;
    }
}