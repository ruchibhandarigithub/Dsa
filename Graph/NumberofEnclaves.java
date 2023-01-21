class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numEnclaves(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int visited[][] = new int[n][m];
      
      Queue<Pair> q = new LinkedList<>();
      // traversal on boundary
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(i==0 || i==n-1 || j==0 || j==m-1){
                  if(grid[i][j]==1){
                      q.add(new Pair(i,j));
                      visited[i][j]=1;
                  }
              }
          }
      }


      int delrow[] ={-1,0,1,0};
      int delcol[] ={0,1,0,-1};
      while(!q.isEmpty()){
          int r = q.peek().r;
          int c = q.peek().c;
          q.remove();
          for(int i=0;i<4;i++){
              int rn = delrow[i]+r;
              int cn = delcol[i]+c;
              if(rn>=0 && rn<n && cn>=0 && cn<m && grid[rn][cn]==1 && visited[rn][cn]==0){
                  q.add(new Pair(rn,cn));
                  visited[rn][cn]=1;
              }
          }
      }
      int count=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==1 && visited[i][j]==0){
                  count++;
                  visited[i][j]=1;
              }
          }
      }
      return count;


    }
}