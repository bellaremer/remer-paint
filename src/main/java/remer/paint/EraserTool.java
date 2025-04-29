package remer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;

public class EraserTool implements Tool
{
    private static final float ERASER_THICKNESS = 20.0f; // Set the thickness of the eraser
    private Color backgroundColor; // Background color to erase to
    private BufferedImage canvas; // The canvas to draw on
    private Graphics2D g2d; // Graphics2D object for drawing

    public EraserTool(BufferedImage canvas)
    {
        this.canvas = canvas;
        this.g2d = canvas.createGraphics();
        this.backgroundColor = Color.WHITE; // Assuming white is the background color
        setEraserStroke(ERASER_THICKNESS); // Set the initial stroke thickness
    }

    public void setEraserStroke(float thickness)
    {
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(backgroundColor);
    }

    @Override
    public void pressed(Graphics2D g, int x, int y)
    {
        g.setColor(backgroundColor);
        erase(x, y); // Erase at the initial press point
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        g.setColor(backgroundColor);
        erase(x, y); // Erase while dragging
    }

    @Override
    public void preview(Graphics2D g) {
        // no preview needed
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {
        // No action needed on release
    }

    private void erase(int x, int y)
    {
        Shape eraserShape = new Ellipse2D.Float(
                x - ERASER_THICKNESS / 2,
                y - ERASER_THICKNESS / 2,
                ERASER_THICKNESS,
                ERASER_THICKNESS);
        g2d.fill(eraserShape);
    }
}