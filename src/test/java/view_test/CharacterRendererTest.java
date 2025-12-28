package view_test;

import gui.Gui;
import model.Position;
import model.entities.characters.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.entities.CharacterRenderer;

import static org.mockito.Mockito.*;

class CharacterRendererTest {

    private CharacterRenderer characterRenderer;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        characterRenderer = new CharacterRenderer();
        mockGui = mock(Gui.class);
    }

    @Test
    void testRender() throws Exception {
        Character mockCharacter = mock(Character.class);
        when(mockCharacter.getPosition()).thenReturn(new Position(10, 20));
        when(mockCharacter.toStringImg()).thenReturn("Knight right");

        characterRenderer.render(mockCharacter, mockGui);
        verify(mockGui).drawImage(anyString(), any(Position.class));
    }
}
