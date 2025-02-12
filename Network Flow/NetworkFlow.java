import java.util.*;

public class NetworkFlow {

    private int totalNodes;
    private int[][] capacityMatrix; 

    public NetworkFlow(int nodes) {
        this.totalNodes = nodes;
        this.capacityMatrix = new int[nodes + 2][nodes + 2]; // accounts for source and sink
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int instances = scan.nextInt();

        for(int i = 0; i < instances; i++) {
            int numNodes = scan.nextInt();
            int numEdges = scan.nextInt();

            NetworkFlow graph = new NetworkFlow(numNodes);

            // add all edges between nodes
            for (int j = 0; j < numEdges; j++) {
                int source = scan.nextInt();
                int dest = scan.nextInt();
                int capacity = scan.nextInt();
                graph.addEdge(source, dest, capacity);
            }

            System.out.println(graph.maxFlow(1, numNodes));
        }
        scan.close();
    }


    public int[][] getCapMatrix(){
        return capacityMatrix;
    }

    // Adder method to create edges with capacity
    public void addEdge(int source, int dest, int capacity) {
        capacityMatrix[source][dest] += capacity;
    }

    

    // Adder method to create edges w/out capacity
    public void addEdge(int source, int dest) {
        capacityMatrix[source][dest] = 1;
    }

   
    private boolean bfs(int[][] residual, int s, int t, int[] parent) {
        boolean[] visited = new boolean[totalNodes + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 1; v <= totalNodes; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    public int maxFlow(int s, int t) {
        int[][] residualGraph = new int[totalNodes + 1][totalNodes + 1];
        for (int i = 1; i <= totalNodes; i++) {
            for (int j = 1; j <= totalNodes; j++) {
                residualGraph[i][j] = capacityMatrix[i][j];
            }
        }

        int[] parent = new int[totalNodes + 1];
        int maxFlow = 0;

        while (bfs(residualGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow ;
    }
}