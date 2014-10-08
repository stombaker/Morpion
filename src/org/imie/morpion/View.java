package org.imie.morpion;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View() throws HeadlessException {
        super("Morpion");
        MorpionDraw morpionDraw = new MorpionDraw();
        morpionDraw.setSize(new Dimension(300, 300));
        add(morpionDraw);
        morpionDraw.repaint();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(300, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
