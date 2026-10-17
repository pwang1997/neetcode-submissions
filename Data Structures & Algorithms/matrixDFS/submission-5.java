class Solution {
    int ans = 0;
    boolean[][] visited;
    public int countPaths(int[][] grid) {
        ans = 0;
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        probe(grid, 0, 0);
        return ans;
    }

    void probe(int[][] grid, int i, int j) {
        if (!isValidRow(grid, i) || !isValidCol(grid, j) || grid[i][j] == 1)
            return;

        if (i == grid.length - 1 && j == grid[0].length - 1 && grid[i][j] == 0) {
            ans++;
            return;
        }

        visited[i][j] = true;
        if (isValidRow(grid, i + 1) && grid[i + 1][j] == 0 && !visited[i + 1][j]) {
            probe(grid, i + 1, j);
        }
        if (isValidRow(grid, i - 1) && grid[i - 1][j] == 0 && !visited[i - 1][j]) {
            probe(grid, i - 1, j);
        }

        if (isValidCol(grid, j + 1) && grid[i][j + 1] == 0 && !visited[i][j + 1]) {
            probe(grid, i, j + 1);
        }
        if (isValidCol(grid, j - 1) && grid[i][j - 1] == 0 && !visited[i][j - 1]) {
            probe(grid, i, j - 1);
        }
        visited[i][j] = false;
    }

    boolean isValidRow(int[][] grid, int v) {
        return v >= 0 && v < grid.length;
    }

    boolean isValidCol(int[][] grid, int v) {
        return v >= 0 && v < grid[0].length;
    }
}
