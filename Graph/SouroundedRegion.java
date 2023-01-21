class Solution {
    public void dfs(int r ,int c,int visited[][],char[][] board,int delrow[],int delcol[]){
        int n = board.length;
        int m = board[0].length;
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int rn = r+delrow[i];
            int cn = c+delcol[i];
            if(rn>=0 && rn<n && cn>=0 && cn<m && board[rn][cn]=='O' && visited[rn][cn]==0){
            dfs(rn,cn,visited,board,delrow,delcol);
        }
        }
        
    }
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

         int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1}; 
        int vis[][] = new int[n][m]; 
        // traverse first row and last row 
        for(int j = 0 ; j<m;j++) {
            // check for unvisited Os in the boundary rws
            // first row 
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol); 
            }
            
            // last row 
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, delrow, delcol); 
            }
        }
        
        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column 
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol); 
            }
            
            // last column
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delrow, delcol); 
            }
        }
        
        // if unvisited O then convert to X
        
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O') 
                    mat[i][j] = 'X'; 
            }
        }
        

   }
}