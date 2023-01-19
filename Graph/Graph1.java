package Graph;
import java.util.Scanner;
public class Graph1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//  no of nodes  
        int  m = sc.nextInt() ; // no of edges
        int verties[][] = new int[n+1][n+1];

        
        for(int i=0;i<m;i++){
           int u = sc.nextInt();
           int v = sc.nextInt();
           addEdge(u, v, verties);
        }
        printAdjacencyMatrix(verties);
        sc.close();
     
    }
    public static void addEdge(int  u,int v,int adj[][])
    {
        adj[u][v]=1;
        adj[v][u]=1;
    }
    public static void printAdjacencyMatrix(int adj[][]){
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].length;j++){
                 System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
}