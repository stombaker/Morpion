package org.imie.morpion.view;


import org.imie.morpion.model.Piece;

import javax.swing.*;
import java.awt.*;

public class NamePanel extends JPanel {
    private View view;
    private JLabel lblPlayer1 = new JLabel("Player 1:");
    private JTextField tfdPlayer1 = new JTextField();
    private JLabel lblPlayer2 = new JLabel("Player 2:");
    private JTextField tfdPlayer2 = new JTextField();

    public NamePanel(View view) {
        this.view = view;
        GridLayout layout = new GridLayout(1, 4);
        setLayout(layout);
        add(lblPlayer1);
        add(tfdPlayer1);
        add(lblPlayer2);
        add(tfdPlayer2);
    }

    public String getPlayer1() {
        return tfdPlayer1.getText();
    }

    public String getPlayer2() {
        return tfdPlayer2.getText();
    }
}
