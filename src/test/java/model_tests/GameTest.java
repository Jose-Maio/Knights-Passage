package model_tests;

import model.Position;
import model.entities.characters.Player;
import model.game.Arena;
import model.game.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    void testNextLevel() {
        int current_level = 1;
        final List<Level> levels = new ArrayList<>();
        boolean gameOver = false;

        levels.add(levels.get(0));
        levels.add(levels.get(1));
    }

    @Test
    void testGameOverWhenPlayerDies() {
    }
}
