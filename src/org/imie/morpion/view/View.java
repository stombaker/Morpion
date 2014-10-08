package org.imie.morpion.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class View extends JFrame {
	private List <ViewListener> viewListenerList=new ArrayList<ViewListener>();
    public View() throws HeadlessException {
        super("Morpion");
        MorpionDraw morpionDraw = new MorpionDraw(null, null);
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
