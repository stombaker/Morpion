package org.imie.morpion.controller;


import org.imie.morpion.model.Game;
import org.imie.morpion.model.Model;
import org.imie.morpion.model.Piece;
import org.imie.morpion.view.View;
import org.imie.morpion.view.ViewListener;

public class Controller implements ViewListener {
    private Model model;
    private View view;

    public Controller() {

    }

    public void start() {
        model.createGame();
    }

    @Override
    public void onClick(int x, int y) {
        Game game = model.getCurrentGame();
        if (game.getMorpionGrid().get(x, y) == Piece.NONE) {
            game.getMorpionGrid().set(x, y, game.getCurrent());
            if (game.getMorpionGrid().checkEnd()) {
                game.setWinner(game.getMorpionGrid().getWinner());
                model.saveGame(game);
            }
        }
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
