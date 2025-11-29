package view;

import gui.Gui;
import model.Position;
import model.entities.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.entities.PlayerRenderer;

class PlayerRendererTest {

    private Player player;
    private PlayerRenderer renderer;
    private Gui gui;

    @BeforeEach
    void setUp() throws Exception {
        player = Mockito.mock(Player.class);
        Mockito.when(player.getPosition()).thenReturn(new Position(10, 10));

        renderer = new PlayerRenderer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() throws Exception {
        renderer.render(player, gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage("sprites/Knight right.png", player.getPosition());
    }
}

