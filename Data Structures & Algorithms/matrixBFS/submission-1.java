class Solution {
    class Pair {
        int r, c, d;

        Pair(int r, int c, int d) {
            this.r = r; this.c = c; this.d = d;
        }
    }
    public int shortestPath(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int r = grid.length, c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.r < 0 || p.c < 0 || p.r >= r || p.c >= c
                || grid[p.r][p.c] == 1 || visited[p.r][p.c]) {
                    continue;
            }
            if(p.r == r-1 && p.c == c - 1) {
                ans = Math.min(ans, p.d);
                continue;
            }
            visited[p.r][p.c] = true;
            q.add(new Pair(p.r, p.c + 1, p.d + 1));
            q.add(new Pair(p.r, p.c - 1, p.d + 1));
            q.add(new Pair(p.r + 1, p.c, p.d + 1));
            q.add(new Pair(p.r - 1, p.c, p.d + 1));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
