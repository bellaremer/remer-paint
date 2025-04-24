package remer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketFillTool implements Tool
{
    private Color newColor;
    PaintController paintController;

    @Override
    public void pressed(Graphics2D g, int x, int y)
    {
        BufferedImage image = ((DrawingComponent) g.getClip()).getImage();
        Color targetColor = new Color(image.getRGB(x, y));
        newColor = paintController.getCurrentColor();

        if (!targetColor.equals(newColor))
        {
            floodFill(image, x, y, targetColor, newColor);
        }
    }

    @Override
    public void dragged(Graphics2D g, int x, int y)
    {
        // No action needed on drag
    }

    @Override
    public void preview(Graphics2D g)
    {
        // No preview needed for paint bucket
    }

    @Override
    public void released(Graphics2D g, int x, int y)
    {
        // No action needed on release
    }

    private void floodFill(BufferedImage image, int x, int y, Color targetColor, Color newColor)
    {
        if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight())
        {
            return; // Out of bounds
        }
        if (!new Color(image.getRGB(x, y)).equals(targetColor))
        {
            return; // Not the target color
        }

        // Change the color of the pixel
        image.setRGB(x, y, newColor.getRGB());

        // Recursively fill the surrounding pixels
        floodFill(image, x + 1, y, targetColor, newColor); // Right
        floodFill(image, x - 1, y, targetColor, newColor); // Left
        floodFill(image, x, y + 1, targetColor, newColor); // Down
        floodFill(image, x, y - 1, targetColor, newColor); // Up
    }
}