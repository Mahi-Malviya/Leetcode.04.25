class Pair{
        int row;
        int col;
    public Pair(int x, int y){
        this.row = x;
        this.col = y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int ones = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                }
                if(grid[i][j] == 1) ones++;
            }
        }
        if((ones == 0 && q.size() != 0) || ones == 0) return 0;
        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int x = curr.row;
                int y = curr.col;
                for(int[] arr : dir){
                    int rw = arr[0] + x;
                    int co = arr[1] + y;
                    if(rw < 0 || co < 0 || rw >= m || co >= n || grid[rw][co] == 0 || grid[rw][co] == 2) continue;

                    if(grid[rw][co] == 1){
                        q.add(new Pair(rw, co));
                        vis[rw][co] = true;
                        grid[rw][co] = 2;
                        ones--;
                    } 
                }
            }
            time++;
        }
        if(ones != 0) return -1;

        return time-1;
    }
}