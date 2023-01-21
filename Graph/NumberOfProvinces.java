class Solution {
    public void bfs(ArrayList<ArrayList<Integer>> adjs,int visited[],int V)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V]=1;
        while(!q.isEmpty()){
           int node = q.remove();
           for(int i : adjs.get(node)){
               if(visited[i]==0){
                   q.add(i);
                   visited[i]=1;
               }
           }

        }

    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int  v[] = new int[V];
        int count=0;
        ArrayList<ArrayList<Integer>> adjs = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjs.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                   adjs.get(i).add(j);
                   adjs.get(j).add(i);

                }
            }
        }
        for(int i=0;i<V;i++){
            if(v[i]==0){
               count++;
               bfs(adjs,v,i);
            }
        } 
        return count;
    
    }
}