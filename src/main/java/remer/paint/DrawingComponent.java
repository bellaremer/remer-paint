package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent extends JComponent
{
    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
    private int oldX = -1;
    private int oldY = -1;
    private int tempLineX1 = -1;
    private int tempLineY1 = -1;
    private int tempLineX2 = -1;
    private int tempLineY2 = -1;

    public DrawingComponent()
    {
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void drawFromMouse(int x, int y, Color color)
    {
        Graphics g = image.getGraphics();
        g.setColor(color);

        if (oldX != -1 && oldY != -1)
        {
            g.drawLine(oldX, oldY, x, y);
        }

        oldX = x;
        oldY = y;
        repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color)
    {
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        repaint();
    }

    // Draw a temporary line while dragging without clearing the canvas
    public void drawTemporaryLine(int x1, int y1, int x2, int y2, Color color)
    {
        // Draw the new temporary line without clearing the previous drawings
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);

        repaint();
    }

    // Clear the temporary line
    public void clearTemporaryLine()
    {
        oldX = -1;
        oldY = -1;
        tempLineX1 = -1;
        tempLineY1 = -1;
        tempLineX2 = -1;
        tempLineY2 = -1;
        repaint();
    }
}