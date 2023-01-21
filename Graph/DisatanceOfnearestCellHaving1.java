//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] s = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int[][] grid = new int[n][m];
                for(int i = 0; i < n; i++){
                    String[] S = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++){
                        grid[i][j] = Integer.parseInt(S[j]);
                    }
                }
                Solution obj = new Solution();
                int[][] ans = obj.nearest(grid);
                for(int i = 0; i < ans.length; i++){
                    for(int j = 0; j < ans[i].length; j++){
                        System.out.print(ans[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        //Function to find distance of nearest 1 in the grid for each cell.
        class Pair{
            int r;
            int c;
            int di;
            Pair(int r,int c,int di){
                this.r =r;
                this.c=c;
                this.di = di;
            }
        }
        public int[][] nearest(int[][] grid)
        {
            // Code here
            int n = grid.length; //  no of row
            int m = grid[0].length; // no of col
            int visited[][] = new int[n][m];
            int distance[][] = new int[n][m];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1){
                      q.add(new Pair(i,j,0));
                      visited[i][j]=1;
    
                    }
                    else{
                        visited[i][j]=0;
                    }
                }
            }
            int row[]={-1,1,0,0};
            int col[]={0,0,-1,1};
            while(!q.isEmpty()){
                int r = q.peek().r;
                int c = q.peek().c;
                int di = q.peek().di;
                q.remove();
                distance[r][c]=di;
                for(int i=0;i<4;i++){
                    int rn = row[i]+r;
                    int cn = col[i]+c;
                    if(rn>=0 && rn<n && cn>=0 && cn<m && visited[rn][cn]!=1){
                        q.add(new Pair(rn,cn,di+1));
                        visited[rn][cn] =1;
                        
                    }
                }
                
            }
            return distance;
            
        }
    }