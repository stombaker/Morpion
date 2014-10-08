package org.imie.morpion.model;


public class MorpionGrid {
    private final int width;
    private final int height;
    private final int align;
    private Piece[][] grid;

    public MorpionGrid(int width, int height, int align) {
        this.width = width;
        this.height = height;
        this.align = align;
        initializeGrid();
    }

    private void initializeGrid() {
        grid = new Piece[width][height];
        for (int y = 0 ; y < width ; y++) {
            for (int x = 0 ; x < height ; x++) {
                grid[y][x] = Piece.NONE;
            }
        }
    }

    public Piece get(int x, int y) {
        return grid[y][x];
    }

    public void set(int x, int y, Piece piece) {
        grid[y][x] = piece;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkEnd() {
        for (int y = 0 ; y < width ; y++) {
            for (int x = 0 ; x < height ; x++) {
                if (grid[y][x] == Piece.NONE) {
                    return false;
                }
            }
        }
        return getWinner() != Piece.NONE;
    }

    public Piece getWinner() {
        // TODO
        return Piece.NONE;
    }

    public static void main(String[] args) {
        MorpionGrid morpionGrid = new MorpionGrid(3, 3, 3);
        morpionGrid.set(0, 0, Piece.CIRCLE);
        morpionGrid.set(0, 1, Piece.CROSS);
        morpionGrid.set(2, 1, Piece.CIRCLE);
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(morpionGrid.get(x, y) + " ");
            }
            System.out.println("");
        }
    }
}