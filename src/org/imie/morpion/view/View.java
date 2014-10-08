package org.imie.morpion.view;

import org.imie.morpion.model.Game;
import org.imie.morpion.model.Model;
import org.imie.morpion.model.ModelListener;
import org.imie.morpion.model.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class View extends JFrame implements ModelListener {
    private Model model;
    private List<ViewListener> viewListenerList = new ArrayList<ViewListener>();

    private NamePanel namePanel = new NamePanel(this);
    private MorpionDraw morpionDraw = new MorpionDraw(this);
    private HistoryPanel historyPanel = new HistoryPanel(this);

    public View() throws HeadlessException {
        super("Morpion");

        JPanel pnlGameAndHistory = new JPanel();
        BorderLayout layoutGAH = new BorderLayout();
        pnlGameAndHistory.setLayout(layoutGAH);
        pnlGameAndHistory.add(morpionDraw, BorderLayout.CENTER);
        pnlGameAndHistory.add(historyPanel, BorderLayout.EAST);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(namePanel, BorderLayout.NORTH);
        add(pnlGameAndHistory, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        historyPanel.onGameEnd();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getPlayer1() {
        return namePanel.getPlayer1();
    }

    public String getPlayer2() {
        return namePanel.getPlayer2();
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
