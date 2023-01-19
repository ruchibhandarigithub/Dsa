package Graph;
import java.util.ArrayList;
import java.util.Scanner;
public class Graph2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//  no of nodes  
        int  m = sc.nextInt() ; // no of edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++ ){
            adj.add(new ArrayList<>());

        }
        
        for(int i=0;i<m;i++){
           int u = sc.nextInt();
           int v = sc.nextInt();
           addEdge(u, v, adj);
        }
        printAdjacencyMatrix(adj);
        sc.close();
     
    }
    public static void addEdge(int  u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void printAdjacencyMatrix(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                 System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}