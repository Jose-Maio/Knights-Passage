package gui_test;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import gui.LanternaGui;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.awt.image.BufferedImage;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanternaGuiTest {
    private LanternaGui gui;
    private Screen screenMock;
    private TextGraphics graphicsMock;

    @BeforeEach
    void setUp() {
        screenMock = mock(Screen.class);
        graphicsMock = mock(TextGraphics.class);
        gui = new LanternaGui(screenMock, graphicsMock, 80, 50);
    }

    @Test
    void testDrawImage() throws IOException {
        Position pos = new Position(10, 10);
        gui.drawImage("test_image.png", pos);

        verify(graphicsMock, times(1)).setCharacter(eq(10), eq(10), any(TextCharacter.class));

        gui.drawImage("test_image.png", pos);
        verify(graphicsMock, times(2)).setCharacter(anyInt(), anyInt(), any(TextCharacter.class));
    }

    @Test
    void testDrawBufferWithoutCaptor() {

        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        int redRGB = 0xFFFF0000;
        buffer.setRGB(0, 0, redRGB);

        gui.drawBuffer(buffer);


        verify(graphicsMock).setCharacter(eq(0), eq(0), argThat(character ->
                character.getBackgroundColor().equals(new TextColor.RGB(255, 0, 0))
        ));
    }

    @Test
    void testDrawImageToBuffer() throws IOException {
        BufferedImage buffer = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);

        gui.drawImageToBuffer("test_image.png", 2, 2, buffer);

        int rgb = buffer.getRGB(2, 2);
        int alpha = (rgb >> 24) & 0xff;
        assertNotEquals(0, alpha);
    }

    @Test
    void testClearAndRefresh() throws IOException {
        gui.clear();
        verify(screenMock).clear();

        gui.refresh();
        verify(screenMock).refresh();
    }

    @Test
    void testInputMethods() throws IOException {
        KeyStroke mockKey = mock(KeyStroke.class);

        when(screenMock.pollInput()).thenReturn(mockKey).thenReturn(null);

        KeyStroke result = gui.step();
        assertEquals(mockKey, result);

        gui.clearInput();
        verify(screenMock, atLeast(2)).pollInput();
    }

    @Test
    void testGetters() {
        assertEquals(80, gui.getWidth());
        assertEquals(50, gui.getHeight());
        assertEquals(screenMock, gui.getScreen());
        assertEquals(graphicsMock, gui.getGraphics());
        assertNotNull(gui.getActiveKeys());
    }

    @Test
    void testDrawImageWithTransparency() {
        BufferedImage transparentBuffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        transparentBuffer.setRGB(0, 0, 0x00FFFFFF);

        gui.drawBuffer(transparentBuffer);

        verify(graphicsMock, never()).setCharacter(anyInt(), anyInt(), any());
    }
}