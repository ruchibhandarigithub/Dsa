
import  java.util.Scanner;

public class FloodFillAlgo {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] image = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int newColor = sc.nextInt();
        int[][] ans = Solution.floodFill(image, x, y, newColor);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(j == m-1) {
                    System.out.print(ans[i][j] + "\n");
                }
                else {
                    System.out.print(ans[i][j] + " ");
                }
            }
        }
    }
}

class Solution
{
	    public static  void dfs(int sr,int sc ,int [][]image,int row[],int col[], int oldColor ,int newColor){
        image[sr][sc]=newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int r = sr+row[i];
            int c = sc+col[i];
            if(r>=0 && r<n && c>=0 && c<m && image[r][c]==oldColor && image[r][c]!=newColor)
            {
                dfs(r,c,image,row,col,oldColor,newColor);
            }
        }

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc]; // oldColor
        int ans[][]=image; // ans array
        int row[] =  {1,-1,0,0}; // array for row  movement
        int col[] = {0,0,1,-1}; // array for col movement
        dfs(sr,sc,ans,row,col,oldColor,color);
        return ans;

        
    }

}

    
}
