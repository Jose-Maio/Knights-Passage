package model.game;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.objects.Object;
import java.util.List;

public class Arena {
    private final List<Object> objectList;
    private final TextColor backgroundColor;

    public Arena(List<Object> objects, TextColor backgroundColor){
        this.objectList = objects;
        this.backgroundColor = backgroundColor;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public TextColor getBackgroundColor() {
        return backgroundColor;
    }

    boolean isBlocked(Position position){
        for(Object object : objectList){
            if(object.getPosition().equals(position)) return true;
        }
        return false;
    }

}
