class Solution {
    public int paths(int i,int j, boolean[][]visited,int[][]grid){
        int n = visited.length,m = visited[0].length;
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(visited[i][j]|| grid[i][j]==-1){
            return 0;
        }

        if(grid[i][j]==2){
            for( i=0;i<grid.length;i++){
                for( j=0;j<grid[0].length;j++){
                    if(grid[i][j]==0){
                        return 0;
                    }
                }
            }
            return 1;
        }
        visited[i][j] = true;
        int ans = 0;
        grid[i][j] = -1;
        ans+= paths(i,j+1,visited, grid);
        ans+= paths(i,j-1,visited, grid);
        ans+= paths(i+1,j,visited, grid);
        ans+= paths(i-1,j,visited, grid);
        grid[i][j] = 0;
        
            visited[i][j] = false;
        return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        boolean[][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                visited[i][j] = false;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                return paths(i,j,visited,grid);
            }
        }
        return 0;
        
    }
}
