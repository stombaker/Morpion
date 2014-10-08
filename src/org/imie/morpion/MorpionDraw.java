package org.imie.morpion;

import javax.swing.*;
import java.awt.*;

public class MorpionDraw extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawLine(0, 0, 300, 300);
    }
}
