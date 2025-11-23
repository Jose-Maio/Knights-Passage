package view.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.entities.characters.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerRenderer implements EntityRenderer {

    BufferedImage sprite = ImageIO.read(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("sprites/Monkey.png")
            )
    );

    public PlayerRenderer() throws IOException {
    }

    public void render(Player player, TextGraphics graphics) {
        for (int x = 0; x < sprite.getWidth(); x++){
            for (int y = 0; y < sprite.getHeight(); y++){
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0) {
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    graphics.setCharacter(player.getPosition().getX() + x, player.getPosition().getY() + y, c);
                }
                System.out.println(alpha + '\n');
            }
        }
    }
}
