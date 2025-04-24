package remer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintController
{
    private Tool currentTool;
    private Color currentColor;

    public PaintController()
    {
        this.currentTool = new LineTool(this); // Default tool
        this.currentColor = Color.BLACK;    // deafult color
    }

    public void setCurrentColor(Color currentColor)
    {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor()
    {
        return this.currentColor;
    }

    public void setTool(Tool tool)
    {
        this.currentTool = tool;
    }

    public Tool getCurrentTool()
    {
        return currentTool;
    }

    public void mousePressed(BufferedImage image, Graphics2D g, int x, int y)
    {
        currentTool.pressed(g, x, y);
    }

    public void mouseDragged(Graphics2D g, int x, int y)
    {
        currentTool.dragged(g, x, y);
    }

    public void mouseReleased(Graphics2D g, int x, int y)
    {
        currentTool.released(g, x, y);
    }

    public void preview(Graphics2D g)
    {
        currentTool.preview(g);
    }
}