class Solution {
    public int[] lastVisitedCell(char[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
        
       boolean[][] visited = new boolean[m][n];

        int r = 0;
        int c = 0;
        while(true){
            visited[r][c] = true;
            int nr = r;
            int nc = c;
        if(grid[r][c] =='U'){
            nr--;
        } else if(grid[r][c] =='D'){
            nr++;
        } else if(grid[r][c] =='L') {
            nc--;     
        } else if(grid[r][c] =='R') {
            nc++;    
        }
        if(nr < 0||nr >= m || nc < 0|| nc >= n){
                return new int[]{r,c};
        }
        if(visited[nr][nc]){
            return new int[]{r,c};
        }
            r = nr;
            c = nc;
        }
    }
}