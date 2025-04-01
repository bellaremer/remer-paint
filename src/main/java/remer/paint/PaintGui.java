package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintGui extends JFrame
{
    // Create a drawing component where the user can draw
    private final DrawingComponent canvas = new DrawingComponent();
    private Color currentColor = Color.BLACK;
    private Point startPoint = null;

    // Constructor to set up the GUI
    public PaintGui()
    {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a button for choosing colors
        JButton colorButton = new JButton("Choose color");
        colorButton.addActionListener(e -> {
            // Update the current color if a new color is selected
            Color newColor = JColorChooser.showDialog(this, "Choose a color", currentColor);
            if (newColor != null)
            {
                currentColor = newColor;
            }
        });

        // Create a panel to hold the color chooser button
        JPanel topPanel = new JPanel();
        topPanel.add(colorButton);
        add(topPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        // Mouse motion listener to the canvas for drawing
        canvas.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                // If the start point is set, draw a line from the start point to the current mouse position
                if (startPoint != null)
                {
                    canvas.drawLine(startPoint.x, startPoint.y, event.getX(), event.getY(), currentColor);
                } else {
                    canvas.drawFromMouse(event.getX(), event.getY(), currentColor);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                // No action needed
            }
        });

        // Add mouse listener to handle mouse clicks and releases
        canvas.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                startPoint = e.getPoint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // No action needed
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (startPoint != null)
                {
                    canvas.drawLine(startPoint.x, startPoint.y, e.getX(), e.getY(), currentColor);
                    startPoint = null;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // No action needed
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // No action needed
            }
        });
    }

    public static void main(String[] args) {
        PaintGui frame = new PaintGui();
        frame.setVisible(true);
    }
}
