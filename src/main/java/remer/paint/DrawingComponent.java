package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent extends JComponent {
    private final BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
    private int oldX = -1;
    private int oldY = -1;
    private int tempX1 = -1, tempY1 = -1, tempX2 = -1, tempY2 = -1;
    boolean isTemporary = false;
    private Color currentColor = Color.BLACK;

    public DrawingComponent() {
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

        if (isTemporary) {
            g.setColor(currentColor);
            g.drawLine(tempX1, tempY1, tempX2, tempY2);
        }
    }

    public void setTemporaryLine(int x1, int y1, int x2, int y2, Color color) {
        tempX1 = x1;
        tempY1 = y1;
        tempX2 = x2;
        tempY2 = y2;
        currentColor = color;
        isTemporary = true;
        repaint();
    }

    // Clear the temporary line
    public void clearTemporaryLine() {
        isTemporary = false;
        repaint();
    }


    public void drawFromMouse(int x, int y, Color color) {
        Graphics g = image.getGraphics();
        g.setColor(color);

        if (oldX != -1 && oldY != -1) {
            g.drawLine(oldX, oldY, x, y);
        }

        oldX = x;
        oldY = y;
        repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
        repaint();
    }

}