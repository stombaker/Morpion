package org.imie.morpion.view;

import org.imie.morpion.model.Game;
import org.imie.morpion.model.Model;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.*;
import java.util.List;


public class HistoryPanel extends JPanel {
    private View view;
    private JTable tblHistory;
    private HistoryTableModel historyTableModel;

    public HistoryPanel(View view) {
        this.view = view;
        historyTableModel = new HistoryTableModel();
        tblHistory = new JTable(historyTableModel);
        add(tblHistory);
    }

    public void onGameEnd() {
        historyTableModel.fireTableDataChanged();
    }

    private class HistoryTableModel extends DefaultTableModel {
        String[] columns = {"Player X", "Player O", "Result"};

        @Override
        public int getRowCount() {
            Model model = view.getModel();
            if (model != null) {
                return model.getHistory().size();
            } else {
                return 0;
            }
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columns[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Game game = view.getModel().getHistory().get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return game.getPlayer1();
                case 1:
                    return game.getPlayer2();
                case 2:
                    return game.getWinner().toString();
                default:
                    return null;
            }
        }
    }
}
