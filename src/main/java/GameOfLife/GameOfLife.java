package GameOfLife;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameOfLife {

    int width;
    int height;
    boolean[][] board;

    /**
     * Simulates a fixed-sized game of life Automaton
     *
     * @param width  The width of the world
     * @param height The height of the world
     */
    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new boolean[width][height];

        for (int x = 0; x < this.width; ++x) {
            for (int y = 0; y < this.height; ++y) {
                board[x][y] = false;
            }
        }
    }

    /**
     * Draws a game of life board.
     *
     * @param context The GraphicsContext to use.
     * @param size    The size of each cell (1.0 = 1px)
     */
    public void draw(GraphicsContext context, double size) {
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (board[x][y]) {
                    // live cell
                    context.setFill(Color.GREEN);
                } else {
                    // dead cell
                    context.setFill(Color.WHITE);
                }
                context.fillRect(x * size, y * size, (x + 1) * size, (y + 1) * size);
            }
        }
    }

    public void step() {
        boolean[][] newBoard = new boolean[width][height];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                int numberOfNeighbors = 0;

                for (int i = x - 1; i <= x + 1; ++i) {
                    for (int j = y - 1; j <= y + 1; ++j) {
                        if (i >= 0 && i < width) {
                            if (j >= 0 && j < height) {
                                if (!(i == x && j == y)) {
                                    numberOfNeighbors += board[i][j] ? 1 : 0;
                                }
                            }
                        }
                    }
                }

                if (board[x][y]) {
                    newBoard[x][y] = numberOfNeighbors == 2 || numberOfNeighbors == 3;
                } else {
                    newBoard[x][y] = numberOfNeighbors == 3;
                }
            }
        }

        board = newBoard;
    }

    public void flip(int x, int y) {
        board[x][y] = !board[x][y];
    }

    public void clear() {
        board = new boolean[width][height];
    }
}
