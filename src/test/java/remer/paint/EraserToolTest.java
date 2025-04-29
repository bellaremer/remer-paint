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

        // when
        tool.pressed(g, canvas, 50, 100);

        // then
        verify(g).setColor(Color.WHITE);
        assertEquals(Color.WHITE.getRGB(), canvas.getRGB(50, 100));
    }

    @Test
    void dragged()
    {
        // given
        canvas.setRGB(200, 150, Color.RED.getRGB());

        // when
        tool.dragged(g, 200, 150);

        // then
        verify(g).setColor(Color.WHITE);
        assertEquals(Color.WHITE.getRGB(), canvas.getRGB(200, 150));
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