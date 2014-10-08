package org.imie.morpion.view;

import org.imie.morpion.model.Game;
import org.imie.morpion.model.Model;
import org.imie.morpion.model.ModelListener;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class View extends JFrame implements ModelListener {
    private Model model;
    private List<ViewListener> viewListenerList = new ArrayList<ViewListener>();

    private MorpionDraw morpionDraw = new MorpionDraw(this);

    public View() throws HeadlessException {
        super("Morpion");
        add(morpionDraw);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(300, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addViewListener(ViewListener viewListener) {
        viewListenerList.add(viewListener);
    }

    public void processOnclick(int x, int y) {
        for (ViewListener viewListener: viewListenerList) {
            viewListener.onClick(x, y);
        }
    }

    @Override
    public void onGameStart(Game game) {
        morpionDraw.repaint();
    }

    @Override
    public void onGameUpdate(Game game) {
        morpionDraw.repaint();
    }

    @Override
    public void onGameEnd(Game game) {
        morpionDraw.repaint();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
