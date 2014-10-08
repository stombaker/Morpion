package org.imie.morpion.model;

public class Game {
    private final String player1;
    private final String player2;
    private String winner = null;

    private MorpionGrid morpionGrid;

    private Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
