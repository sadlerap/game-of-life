package GameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {
    @Test
    void testTransition() {
        GameOfLife gol = new GameOfLife(3, 3);
        boolean[][] board = {{false, true, false}, {false, true, false}, {false, true, false}};
        gol.board = board;

        gol.step();

        boolean[][] result = {{false, false, false}, {true, true, true}, {false, false, false}};

        Assertions.assertArrayEquals(gol.board, result);
    }
}
