package remer.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EraserToolTest
{

    private Graphics g = mock(Graphics.class);

    @Test
    void pressed()
    {
        // given
        EraserTool tool = new EraserTool();

        // when
        tool.pressed(g, 50, 100);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).fillRect(45, 95, 10, 10);    // 50 - 5, 100 -5, 10, 10
    }

    @Test
    void dragged()
    {
        // given
        EraserTool tool = new EraserTool();

        // when
        tool.dragged(g, 200, 150);

        // then
        verify(g).setColor(Color.WHITE);
        verify(g).fillRect(195, 145, 10, 10);   // 200 -5, 150 - 5, 10, 10
    }

    @Test
    void released()
    {
        // given
        EraserTool tool = new EraserTool();

        // when
        tool.released(g, 100, 200);

        // then
        // No action needed on release, so no verification
    }
}