package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

        // Creating the eraser button
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(e ->
        {
            controller.setTool(new EraserTool());
            canvas.setTool(controller.getCurrentTool());
        });
        buttonPanel.add(eraserButton);

        // Button for color selection
        JButton colorButton = new JButton("Select Color");
        colorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(PaintGui.this, "Choose Color", Color.BLACK);
            if (newColor != null) {
                controller.setCurrentColor(newColor); // Update the controller with the new color
            }
        });
        buttonPanel.add(colorButton);

        // Add the button panel to the top of the window
        add(buttonPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        canvas.setTool(controller.getCurrentTool());


        canvas.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                controller.mouseDragged(canvas.getImage().getGraphics(), e.getX(), e.getY());
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
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                controller.mousePressed(canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                controller.mouseReleased(canvas.getImage().getGraphics(), e.getX(), e.getY());
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