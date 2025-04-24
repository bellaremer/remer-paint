package remer.paint;

import java.awt.*;

public interface Tool
{
    void pressed(Graphics2D g, int x, int y);

    void dragged(Graphics2D g, int x, int y);

    void preview(Graphics2D g);

    void released(Graphics2D g, int x, int y);
}
