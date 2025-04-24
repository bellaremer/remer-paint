package remer.paint;

import java.awt.*;

public class EraserTool implements Tool
{
    private static final int eraserSize = 10; //size of the eraser

    @Override
    public void pressed(Graphics2D g, int x, int y)
    {
        erase(g, x, y);
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        erase(g, x, y);
    }

    @Override
    public void preview(Graphics2D g)
    {
        // No preview needed for eraser
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {
        // No action needed on release
    }

    private void erase(Graphics2D g, int x, int y)
    {
        g.setColor(Color.WHITE);
        // center the rectange around x,y
        int halfSize = eraserSize / 2;
        g.fillRect(x - halfSize, y - halfSize, eraserSize, eraserSize);
    }
}
