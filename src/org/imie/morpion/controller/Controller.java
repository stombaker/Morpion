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
        model.getCurrentGame().setCurrent(Piece.CROSS);
        model.gameStart();
    }

    @Override
    public void onClick(int x, int y) {
        Game game = model.getCurrentGame();
        if (!game.isEnded()) {
            if (game.getMorpionGrid().get(x, y) == Piece.NONE) {
                Piece piece = model.getCurrentGame().getCurrent();
                if (piece == Piece.CROSS) {
                    game.getMorpionGrid().set(x, y, Piece.CROSS);
                    game.setCurrent(Piece.CIRCLE);
                } else {
                    game.getMorpionGrid().set(x, y, Piece.CIRCLE);
                    game.setCurrent(Piece.CROSS);
                }
                if (game.isEnded()) {
                    model.saveGame(game);
                    model.gameEnd();
                }
                model.gameUpdate();
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
