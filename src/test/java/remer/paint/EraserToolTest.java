package remer.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EraserToolTest
{
    private final BufferedImage canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);;
    private final Graphics2D g = mock(Graphics2D.class);
    private final EraserTool tool = new EraserTool(canvas);

    @Test
    void pressed()
    {
        // given

        // when
        tool.pressed(g, 50, 100);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).fill(any(Shape.class)); //Verify that fill is called with any shape
    }

    @Test
    void dragged()
    {
        // given

        // when
        tool.dragged(g, 200, 150);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).fill(any(Shape.class));
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