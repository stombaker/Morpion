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

    public void initializeGrid() {
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
        if (getWinner() != Piece.NONE) {
            return true;
        }
        for (int y = 0 ; y < width ; y++) {
            for (int x = 0 ; x < height ; x++) {
                if (grid[y][x] == Piece.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check the grid and return the winner of this game (NONE if any).
     * @return The winner of this game.
     */
    public Piece getWinner() {
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                if (winHere(x, y)) {
                    return get(x, y);
                }
            }
        }
        return Piece.NONE;
    }

    /**
     * Check if the current and cases on the right, on the bottom, on the bottom-left or on the bottom-right
     * are of the same type
     * <p>
     * <pre>
     *     Example (align = 3):
     *     X O _
     *     _ X _
     *     _ O X
     *     valid for x = 0 and y = 0
     *     invalid for x = 1 and y = 1 (we do not check up cases).
     * </pre>
     *
     * @param x The current x-axis
     * @param y The current y-axis
     * @return  true if we win with this case, false otherwise
     */
    private boolean winHere(int x, int y) {
        return  winHereRight(x, y) ||
                winHereBottom(x, y) ||
                winHereBottomLeft(x, y) ||
                winHereBottomRight(x, y);
    }

    private boolean winHereRight(int x, int y) {
        if (x + align <= width) {
            for (int i = 1 ; i < align ; i++) {
                if (get(x, y) != get(x + i, y)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean winHereBottom(int x, int y) {
        if (x + align <= width) {
            for (int i = 1 ; i < align ; i++) {
                if (get(x, y) != get(x, y + i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean winHereBottomLeft(int x, int y) {
        if (x - align >= -1 && y + align <= height) {
            for (int i = 1 ; i < align ; i++) {
                if (get(x, y) != get(x - i, y + i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean winHereBottomRight(int x, int y) {
        if (x + align <= width && y + align <= height) {
            for (int i = 1 ; i < align ; i++) {
                if (get(x, y) != get(x + i, y + i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MorpionGrid morpionGrid = new MorpionGrid(3, 3, 3);
        morpionGrid.set(0, 0, Piece.CROSS);
        morpionGrid.set(1, 0, Piece.CIRCLE);
        morpionGrid.set(1, 1, Piece.CROSS);
        morpionGrid.set(1, 2, Piece.CIRCLE);
        morpionGrid.set(2, 2, Piece.CROSS);
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                switch (morpionGrid.get(x, y)) {
                    case CROSS: System.out.print("X");
                        break;
                    case CIRCLE: System.out.print("O");
                        break;
                    case NONE: System.out.print(" ");
                        break;
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println(morpionGrid.checkEnd());
        System.out.println(morpionGrid.getWinner());
    }
}