package gui;

import javax.swing.*;
import java.awt.*;

public class NodeUI extends JButton {
    public Point p;

    public NodeUI(Point p) {
        this.p = p;
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("Sans Serif", Font.BOLD, 40));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
}
