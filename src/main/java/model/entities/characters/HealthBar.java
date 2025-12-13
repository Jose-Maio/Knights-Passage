package model.entities.characters;

import model.Position;


import java.awt.*;


public class HealthBar {
    private final Position position;
    private final Character character;

    public HealthBar(Character character){
        this.character = character;

        int cY = character.getPosition().getY();


        if(cY < 2){
            position = new Position(character.getPosition().getX(), cY + 17);
        }

        else {
            position = new Position(character.getPosition().getX(), cY - 1);
        }
    }

    public String toStringImg() {
        double percentage =
                (double) character.getHealth() / character.getMaxHealth();

        if (percentage <= 0.20) return "sprites/characters/health_bars/health_1_5.png";
        if (percentage <= 0.40) return "sprites/characters/health_bars/health_2_5.png";
        if (percentage <= 0.60) return "sprites/characters/health_bars/health_3_5.png";
        if (percentage <= 0.80) return "sprites/characters/health_bars/health_4_5.png";
        return "sprites/characters/health_bars/health_full.png";
    }

    public Position getPosition() {
        return position;
    }
}
