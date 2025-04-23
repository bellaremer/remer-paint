package remer.paint;

import java.awt.*;

public class PaintController
{
    private Tool currentTool;
    private Color currentColor;

    public PaintController() {
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

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void mousePressed(Graphics g, int x, int y)
    {
        currentTool.pressed(g, x, y);
    }

    public void mouseDragged(Graphics g, int x, int y)
    {
        currentTool.dragged(g, x, y);
    }

    public void mouseReleased(Graphics g, int x, int y)
    {
        currentTool.released(g, x, y);
    }

    public void preview(Graphics g)
    {
        currentTool.preview(g);
    }
}