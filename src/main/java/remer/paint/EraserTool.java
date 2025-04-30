package remer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EraserTool implements Tool
{
    private int prevX;
    private int prevY;
    private final float ERASER_THICKNESS = 20.0f;
    private BasicStroke eraserStroke;
    private Color backgroundColor;

    public EraserTool(BufferedImage canvas)
    {
        this.eraserStroke = new BasicStroke(ERASER_THICKNESS, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        this.backgroundColor = Color.WHITE;
    }

    @Override
    public void pressed(Graphics2D g, BufferedImage image, int x, int y)
    {
        g.setColor(backgroundColor);
        g.setStroke(eraserStroke);
        prevX = x;
        prevY = y;
        g.drawLine(x, y, x, y); // Draw a point where the eraser is pressed
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        g.setColor(backgroundColor);
        g.setStroke(eraserStroke);
        g.drawLine(prevX, prevY, x, y);
        prevX = x;
        prevY = y;
    }

    @Override
    public void preview(Graphics2D g) {
        // no preview needed
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {
        g.setColor(backgroundColor);
        g.setStroke(eraserStroke);
        g.drawLine(prevX, prevY, x, y);
    }

}