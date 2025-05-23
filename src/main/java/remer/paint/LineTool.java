package remer.paint;

import java.awt.*;

public class LineTool implements Tool
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    private PaintController controller;

    public LineTool(PaintController controller)
    {
        this.controller = controller;
    }

    @Override
    public void pressed(Graphics g, int x, int y)
    {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
        g.setColor(controller.getCurrentColor());   // set color from the controller
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics g, int x, int y)
    {
       this.x2 = x;
       this.y2 = y;
    }

    @Override
    public void preview(Graphics g)
    {
        g.setColor(controller.getCurrentColor());
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void released(Graphics g, int x, int y)
    {
        g.setColor(controller.getCurrentColor());
        g.drawLine(this.x1, this.y1, x, y);
    }
}
