package remer.paint;

import java.awt.*;

public interface Tool
{
    void pressed(Graphics g, int x, int y);

    void dragged(Graphics g, int x, int y);

    /**
     * Draws a preview of the tools operation if released is called
     * @param g
     */
    void preview(Graphics g);

    void released(Graphics g, int x, int y);
}
