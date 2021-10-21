package dsa;

import java.util.*;

public class GraphIsTree {

    private int vertexCount;
    private static LinkedList<Integer> adj[];

    GraphIsTree(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        // ensure i is within 0 to vertexCount
        if(i<vertexCount){
            return true;
        }
        return false;
    }

    private boolean isCyclic(int v, boolean visited[], int parent) {
        // mark node as visited
        visited[v] = true;

        for(int node: adj[v]){
            // if child node is not visited, recursively check for cycle
            if(!visited[node]){
                if(isCyclic(node, visited, v)){
                    return true;
                }
            } else {
                // if child node is visited and not parent, contains cycle
                if(parent != node){
                    return true;
                }
            }
        }

        // no cycle
        return false;
    }

    public boolean isTree() {
        // Write Code here
        boolean visited[] = new boolean[vertexCount];

        if(isCyclic(0, visited, -1)){
            return false;
        }


        for(int i=0; i<vertexCount; i++){
            if(!visited[i]){
                return false;
            }
        }

        // find number of edges
        int edgeCount = 0;
        for(int i=0; i<vertexCount; i++){
            edgeCount += adj[i].size();
        }

        // check whether node has n-1 edges
        if(edgeCount/2 != vertexCount-1){
            return false;
        }

        // graph is tree
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes =  sc.nextInt();
        // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();

        GraphIsTree graph = new GraphIsTree(noOfNodes);
        // Adding edges to the graph
        for (int i = 0; i <noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        if (graph.isTree()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
