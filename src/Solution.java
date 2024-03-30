import java.util.*;


class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        return breadthFs(V, adj, X);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        floodFillRecursive(image, sr, sc, newColor, oldColor);
        return image;
    }

    private void floodFillRecursive(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <=1; y++){
                if(sr+x < 0 || sr+x == image.length || sc + y < 0 || sc + y == image[0].length || (sr == 0 && sc == 0)){
                    continue;
                }
                floodFillRecursive(image, sr+x, sc+y, newColor, oldColor);
            }
        }
    }

    int breadthFs(int V, ArrayList<ArrayList<Integer>> adj, int X){
        Queue<NodeAndDepth> nodeQueue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        nodeQueue.add(new NodeAndDepth(0, 0));
        visited[0] = true;
        while(!nodeQueue.isEmpty()){
            NodeAndDepth polledNode = nodeQueue.poll();
            if(polledNode.node == X) return polledNode.depth;
            for(Integer neighbor : adj.get(polledNode.node)){
                if(!visited[neighbor]){
                    nodeQueue.add(new NodeAndDepth(neighbor, 1 + polledNode.depth));
                    visited[neighbor] = true;
                }
            }
        }
        return -1;
    }

    private static class NodeAndDepth{
        public int node = -1;
        public int depth = -1;
        public NodeAndDepth(int node, int depth){
            this.node = node; this.depth = depth;
        }
    }
}