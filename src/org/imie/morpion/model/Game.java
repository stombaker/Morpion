package org.imie.morpion.model;

public class Game {
    private String player1;
    private String player2;
    private Piece winner = null;
    private Piece current;

    private final MorpionGrid morpionGrid;

    public Game(int width, int height, int align) {
        morpionGrid = new MorpionGrid(width, height, align);
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public Piece getWinner() {
        return winner;
    }

    public void setWinner(Piece winner) {
        this.winner = winner;
    }

    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

    public MorpionGrid getMorpionGrid() {
        return morpionGrid;
    }
}
