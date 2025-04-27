package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class PaintGui extends JFrame
{
    private final DrawingComponent canvas = new DrawingComponent();
    private final PaintController controller = new PaintController();

    public PaintGui()
    {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        // Button for line tool
        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e ->
        {
            controller.setTool(new LineTool(controller));
            canvas.setTool(controller.getCurrentTool());
        });
        buttonPanel.add(lineButton);

        // Inside the PaintGui constructor, when setting up the eraser button
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(e -> {
            controller.setTool(new EraserTool(canvas.getImage())); // Pass the canvas image to the eraser tool
            canvas.setTool(controller.getCurrentTool());
        });
        buttonPanel.add(eraserButton);

        // Button for color selection
        JButton colorButton = new JButton("Select Color");
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(PaintGui.this, "Choose Color", Color.BLACK);
            if (newColor != null)
            {
                controller.setCurrentColor(newColor); // Update the controller with the new color
            }
        });
        buttonPanel.add(colorButton);

        // Button for bucket fill tool
        JButton bucketButton = new JButton("Bucket Fill");
        bucketButton.addActionListener(e -> {
            controller.setTool(new BucketFillTool(canvas)); // Pass the canvas to the tool
            canvas.setTool(controller.getCurrentTool());
        });
        buttonPanel.add(bucketButton);

        // Add the button panel to the top of the window
        add(buttonPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        canvas.setTool(controller.getCurrentTool());
        
        canvas.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                controller.mouseDragged((Graphics2D) canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                // No action needed
            }
        });

        canvas.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                // No action needed
            }

            @Override
            public void mousePressed(MouseEvent e) {
                BufferedImage image = canvas.getImage();
                Graphics2D g = (Graphics2D) image.getGraphics();
                g.setColor(Color.BLACK);
                controller.mousePressed(image, g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                controller.mouseReleased((Graphics2D) canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
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