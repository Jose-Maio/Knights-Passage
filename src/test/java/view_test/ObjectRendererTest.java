package view_test;

import gui.Gui;
import model.Position;
import model.entities.objects.Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.entities.ObjectRenderer;

import java.awt.image.BufferedImage;

import static org.mockito.Mockito.*;

class ObjectRendererTest {

    private ObjectRenderer objectRenderer;
    private Gui mockGui;

    @BeforeEach
    void setUp() {
        objectRenderer = new ObjectRenderer();
        mockGui = mock(Gui.class);
    }

    @Test
    void testRender() throws Exception {
        Object mockObject = mock(Object.class);
        when(mockObject.getPosition()).thenReturn(new Position(10, 20));
        when(mockObject.toStringImg()).thenReturn("Tree");

        objectRenderer.render(mockObject, mockGui);
        verify(mockGui).drawImage(anyString(), any(Position.class));
    }

    @Test
    void testRenderToBuffer() throws Exception {
        Object mockObject = mock(Object.class);
        when(mockObject.getPosition()).thenReturn(new Position(15, 15));
        when(mockObject.toStringImg()).thenReturn("Key");
        BufferedImage buffer = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        objectRenderer.renderToBuffer(mockObject, buffer, mockGui);
        verify(mockGui).drawImageToBuffer(anyString(), eq(15), eq(15), eq(buffer));
    }
}
