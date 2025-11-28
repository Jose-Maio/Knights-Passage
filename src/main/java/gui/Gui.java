package gui;


import model.Position;
import java.io.IOException;

public interface Gui {
     public void drawImage(String img,  Position position) throws IOException;

     public void fillBackground(String img) throws IOException;


}
