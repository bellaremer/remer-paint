package remer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LineTool implements Tool
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    private final PaintController controller;

    public LineTool(PaintController controller)
    {
        this.controller = controller;
    }

    @Override
    public void pressed(Graphics2D g, BufferedImage image, int x, int y)
    {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
        g.setColor(controller.getCurrentColor());   // set color from the controller
        g.drawLine(x, y, x, y);
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        // update the endpoint for preview
        this.x2 = x;
        this.y2 = y;
    }


    @Override
    public void preview(Graphics2D g)
    {
        g.setColor(controller.getCurrentColor());
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {
        g.setColor(controller.getCurrentColor());
        g.drawLine(this.x1, this.y1, x, y);
    }

}
