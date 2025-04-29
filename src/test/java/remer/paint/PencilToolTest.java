package remer.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PencilToolTest
{
    private final BufferedImage canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    private final Graphics2D g = mock(Graphics2D.class);
    private final PencilTool tool = new PencilTool();

    @Test
    void pressed()
    {
        // given

        // when
        tool.pressed(g, canvas, 50, 100);

        // then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).drawLine(50, 100, 50, 100);
    }

    @Test
    void dragged()
    {
        // given
        tool.pressed(g, canvas, 50, 100);

        // when
        tool.dragged(g, 200, 150);

        // then
        assertEquals(200, tool.getX());
        assertEquals(150, tool.getY());
        verify(g).drawLine(50, 100, 200, 150);
    }

    @Test
    void released()
    {
        // given

        //when
        tool.released(g,100, 200);

        // then
        verifyNoMoreInteractions(g);
    }
}