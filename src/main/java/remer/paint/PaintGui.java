package remer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintGui extends JFrame {
    private final DrawingComponent canvas = new DrawingComponent();
    private Color currentColor = Color.BLACK;
    private Point startPoint = null;
    private boolean isLineToolActive = false; // Track if line tool is active

    private PencilTool pencilTool = new PencilTool();

    public PaintGui() {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton colorButton = new JButton("Choose color");
        colorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Choose a color", currentColor);
            if (newColor != null) {
                currentColor = newColor;
            }
        });

        JButton lineButton = new JButton("Line Tool");
        lineButton.addActionListener(e -> {
            isLineToolActive = !isLineToolActive;
            lineButton.setText(isLineToolActive ? "Line Tool (Active)" : "Line Tool");
        });

        JPanel topPanel = new JPanel();
        topPanel.add(colorButton);
        topPanel.add(lineButton);
        add(topPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                pencilTool.dragged(canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // No action needed
            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                pencilTool.pressed(canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                pencilTool.released(canvas.getImage().getGraphics(), e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // No action needed
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // No action needed
            }
        });
    }

    public static void main(String[] args) {
        PaintGui frame = new PaintGui();
        frame.setVisible(true);
    }
}