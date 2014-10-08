package org.imie.morpion.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Game currentGame;

    private List<ModelListener> modelListenerList = new ArrayList<ModelListener>();

    private List<Game> history = new ArrayList<Game>();

    public void addModelListener(ModelListener listener) {
        modelListenerList.add(listener);
    }

    public void createGame(int width, int height, int align) {
        currentGame = new Game(width, height, align);
    }

    public void createGame() {
        createGame(3, 3, 3);
    }

    public void saveGame(Game game) {
        history.add(game);
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void gameStart() {
        for (ModelListener modelListener: modelListenerList) {
            modelListener.onGameStart(currentGame);
        }
    }

    public void gameUpdate() {
        for (ModelListener modelListener: modelListenerList) {
            modelListener.onGameUpdate(currentGame);
        }
    }

    public void gameEnd() {
        for (ModelListener modelListener: modelListenerList) {
            modelListener.onGameEnd(currentGame);
        }
    }
}
