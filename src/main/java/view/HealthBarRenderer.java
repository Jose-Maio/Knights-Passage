package view;

import gui.Gui;
import model.Position;
import model.entities.characters.Character;
import model.entities.characters.enemies.Boss;

import java.io.IOException;

public class HealthBarRenderer {


    public void render(Character character, Gui gui) throws IOException {
        String imgPath = getHealthBarImgPath(character);
        Position pos = calculatePosition(character);
        gui.drawImage(imgPath, pos);}

    private Position calculatePosition(Character character) {
        int cY = character.getPosition().getY();
        if(cY < 2){
            return new Position(character.getPosition().getX(), cY + 17);
        } else {
            return new Position(character.getPosition().getX(), cY - 1); }
    }

    private String getHealthBarImgPath(Character character) {
        if (character instanceof Boss) {
            return getBossHealthBarImgPath(character);
        }
        double percentage = (double) character.getHealth() / character.getMaxHealth();
        if (percentage <= 0.20) return "sprites/characters/health_bars/health_1_5.png";
        else if (percentage <= 0.40) return "sprites/characters/health_bars/health_2_5.png";
        else if (percentage <= 0.60) return "sprites/characters/health_bars/health_3_5.png";
        else if (percentage <= 0.80) return "sprites/characters/health_bars/health_4_5.png";
        return "sprites/characters/health_bars/health_full.png";
    }

    private String getBossHealthBarImgPath(Character boss){
        double percentage = (double) boss.getHealth() / boss.getMaxHealth();
        if (percentage <= 0.10) return "sprites/characters/health_bars/boss_health_1_10.png";
        else if (percentage <= 0.20) return "sprites/characters/health_bars/boss_health_2_10.png";
        else if (percentage <= 0.30) return "sprites/characters/health_bars/boss_health_3_10.png";
        else if (percentage <= 0.40) return "sprites/characters/health_bars/boss_health_4_10.png";
        else if (percentage <= 0.50) return "sprites/characters/health_bars/boss_health_5_10.png";
        else if (percentage <= 0.60) return "sprites/characters/health_bars/boss_health_6_10.png";
        else if (percentage <= 0.70) return "sprites/characters/health_bars/boss_health_7_10.png";
        else if (percentage <= 0.80) return "sprites/characters/health_bars/boss_health_8_10.png";
        else if (percentage <= 0.90) return "sprites/characters/health_bars/boss_health_9_10.png";

        return "sprites/characters/health_bars/boss_health_full.png";

    }
}
