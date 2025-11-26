package model.game;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.objects.Object;
import java.util.List;

public class Arena {
    private final List<? extends Object> objectList;
    private final String backgroundImg;
    private final int width;
    private final int height;

    public Arena(List<? extends Object> objects, String backgroundImg){
        this.objectList = objects;
        this.backgroundImg = backgroundImg;
        this.width = 400;
        this.height = 208;
    }

    public List<? extends Object> getObjectList() {
        return objectList;
    }

    public boolean isBlocked(Position position){
        for(Object object : objectList){
            if(object.getPosition().equals(position)) return true;
        }
        return false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }
}
