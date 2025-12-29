package view_test;

import gui.Gui;
import model.Button;
import model.Position;
import model.game.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuViewTest {

    private Gui mockGui;
    private MenuView menuView;
    private Menu mockMenu;

    @BeforeEach
    void setUp() {
        mockGui = mock(Gui.class);
        menuView = new MenuView(mockGui);
        mockMenu = mock(Menu.class);
    }

    @Test
    void testRender() throws IOException {
        List<Button> buttons = new ArrayList<>();
        buttons.add(new Button(model.Options.START, new Position(10, 10)));

        when(mockMenu.getBackgroundImg()).thenReturn("bg.png");
        when(mockMenu.getButtons()).thenReturn(buttons);

        menuView.render(mockMenu);

        verify(mockGui, atLeastOnce()).drawImage(anyString(), any(Position.class));
        verify(mockGui, times(1)).refresh();
    }
}
