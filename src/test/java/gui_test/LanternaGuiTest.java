package gui_test;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import gui.LanternaGui;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanternaGuiTest {
    private LanternaGui gui;

    @BeforeEach
    void setUp() throws Exception {
        gui = new LanternaGui();
    }

    @Test
    void testGetActiveKeys() {
        assertNotNull(gui.getActiveKeys());
        assertTrue(gui.getActiveKeys().isEmpty());
    }

    @Test
    void testDimensions() {
        assertTrue(gui.getWidth() > 0);
        assertTrue(gui.getHeight() > 0);
    }

    @Test
    void testDrawBufferLogic() {
        BufferedImage buffer = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

        buffer.setRGB(0, 0, 0xFFFF0000);

        assertDoesNotThrow(() -> gui.drawBuffer(buffer));
    }



    @Test
    void testClearInput() {

        assertDoesNotThrow(() -> gui.clearInput());
    }
}