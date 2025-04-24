package remer.paint;

import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LineToolTest
{

    private Graphics2D g = mock(Graphics2D.class);
    private PaintController controller = mock(PaintController.class);

    @Test
    void pressed()
    {
        // given
        LineTool tool = new LineTool(controller);

        // when
        tool.pressed(g, 50, 100);

        // then
        assertEquals(50, tool.x1);
        assertEquals(100, tool.y1);
        verify(g).drawLine(50, 100, 50, 100);
    }

    @Test
    void dragged()
    {
        // given
        LineTool tool = new LineTool(controller);
        tool.pressed(g, 50, 100);

        // when
        tool.dragged(g, 200, 150);

        // then
        assertEquals(200, tool.x2);
        assertEquals(150, tool.y2);
    }

    @Test
    void preview()
    {
        // given
        LineTool tool = new LineTool(controller);
        tool.pressed(g, 50, 100);
        tool.dragged(g, 200, 150);

        // when
        tool.preview(g);

        // then
        verify(g).drawLine(50, 100, 200, 150);
    }

    @Test
    void released()
    {
        // given
        LineTool tool = new LineTool(controller);
        tool.pressed(g, 50, 100);

        // when
        tool.released(g, 200, 150);

        // then
        verify(g).drawLine(50, 100, 200, 150);
    }
}