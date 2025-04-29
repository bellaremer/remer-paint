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
    public void pressed(Graphics2D g, BufferedImage image, int x, int y)
    {
        g.setColor(backgroundColor);
        erase(g, x, y); // Erase at the initial press point
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        g.setColor(backgroundColor);
        erase(g, x, y); // Erase while dragging
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

    private void erase(Graphics2D g, int x, int y)
    {
        int halfThickness = (int) (ERASER_THICKNESS / 2);

        // Loop though the area of the eraser
        for (int i = -halfThickness; i <= halfThickness; i++)
        {
            for (int j = -halfThickness; j <= halfThickness; j++)
            {
                // Check if the current point is within the circular area
                if (i * i + j * j <= halfThickness * halfThickness)
                {
                    // set the pizel color to the background color
                    canvas.setRGB(x + i, y + j, backgroundColor.getRGB());
                }
            }
        }
    }
}