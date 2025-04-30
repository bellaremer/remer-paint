package remer.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EraserToolTest
{
    private final BufferedImage canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    private final Graphics2D g = mock(Graphics2D.class);
    private final EraserTool tool = new EraserTool(canvas);

    @Test
    void pressed()
    {
        // given
        canvas.setRGB(50, 100, Color.RED.getRGB());
        Graphics2D g = canvas.createGraphics();

        // when
        tool.pressed(g, canvas, 50, 100);
        g.dispose();

        // then
        assertEquals(Color.WHITE.getRGB(), canvas.getRGB(50, 100));
    }

    @Test
    void dragged()
    {
        // given
        canvas.setRGB(200, 150, Color.RED.getRGB());
        Graphics2D g = canvas.createGraphics(); // Use a real Graphics2D object
        tool.pressed(g, canvas, 200, 150); // Simulate pressing first

        // when
        tool.dragged(g, 250, 150); // Drag to a new position
        g.dispose(); // Dispose of the graphics context

        // then
        assertEquals(Color.WHITE.getRGB(), canvas.getRGB(200, 150)); // Check the original point
        assertEquals(Color.WHITE.getRGB(), canvas.getRGB(250, 150)); // Check the dragged point
    }

    @Test
    void released()
    {
        // given
        // when
        tool.released(g, 100, 200);

        // then
        // No action needed on release, so no verification
    }
}