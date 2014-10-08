package org.imie.morpion.model;


public interface ModelListener {
    void onGameStart(Game game);
    void onGameUpdate(Game game);
    void onGameEnd(Game game);
}
