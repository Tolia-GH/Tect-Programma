package Test;

import Main.DFS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DFSTest {
    @DisplayName("Test for DFS. Start point is considered as parameter")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testGraph1(int i) {
        DFS dfs = new DFS(8);
        int[][] answers = {
                {-1, 0, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {2, 0, -1, -1, 2, -1, 4, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 4, -1},
                {-1, 5, -1, 5, -1, -1, -1, -1},
                {-1, -1, -1, -1, 6, -1, -1, -1},
                {-1, 5, -1, 5, -1, 7, -1, -1}
        };
        int[][] map = {{1}, {}, {0, 4, 6}, {}, {6}, {1, 3}, {4}, {5}};
        dfs.solve(map, i);
        Assertions.assertArrayEquals(answers[i], dfs.getParent());
    }
    @DisplayName("Test for DFS. Start point is considered as parameter")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testGraph2(int i) {
        DFS dfs = new DFS(8);
        int[][] answers = {
                {-1, 0, -1, -1, -1, -1, 1, 6},
                {1, -1, -1, -1, -1, -1, 1, 6},
                {-1, -1, -1, -1, 2, -1, 4, 6},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, 4, -1, -1, -1, 4, 6},
                {-1, -1, -1, 5, -1, -1, 7, 5},
                {-1, -1, -1, -1, -1, -1, -1, 6},
                {-1, -1, -1, -1, -1, -1, 7, -1}
        };
        int[][] map = {{1}, {0,6}, {4}, {},{2,6}, {3,7}, {7}, {6}};
        dfs.solve(map, i);
        Assertions.assertArrayEquals(answers[i], dfs.getParent());
    }
}
