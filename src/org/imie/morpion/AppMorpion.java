package org.imie.morpion;


import org.imie.morpion.controller.Controller;
import org.imie.morpion.model.Model;
import org.imie.morpion.view.View;

import javax.swing.*;

public class AppMorpion {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controller controller = new Controller();
                View view = new View();
                Model model = new Model();

                controller.setView(view);
                view.addViewListener(controller);
                controller.setModel(model);
                view.setModel(model);
                model.addModelListener(view);

                controller.start();
            }
        });
    }
}
