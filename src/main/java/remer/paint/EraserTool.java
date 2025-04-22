package remer.paint;

import java.awt.*;

public class EraserTool implements Tool
{
    @Override
    public void pressed(Graphics g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10); // Erase a 10x10 square
    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10); // Erase a 10x10 square
    }

    @Override
    public void preview(Graphics g)
    {
        // No preview needed for eraser
    }

    @Override
    public void released(Graphics g, int x, int y)
    {
        // No action needed on release
    }
}
