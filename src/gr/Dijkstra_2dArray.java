package gr;

public class Dijkstra_2dArray {
    public static void dijkstra_SSSP(int[][] graph, int sourceVertex){
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        
        distance[sourceVertex] = 0; // distance of source vertex to itself is zero
        
        for (int i = 0; i < vertexCount; i++){
            int u = findMinDistance(distance, visitedVertex);
            
            // Safety check for disconnected graphs
            if (u == -1) break; 
            
            visitedVertex[u] = true;
            
            for (int v = 0; v < vertexCount; v++){
                // Check distance[u] != Integer.MAX_VALUE to prevent integer overflow
                if(!visitedVertex[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        
        // FIXED: The print statement is now on a single line to resolve the syntax error
        for (int i = 0; i < distance.length; i++){
            System.out.println(String.format("Distance from source vertex %s to vertex %s is %s", sourceVertex, i, distance[i]));
        }
    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++){
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
            { 0, 4, 8, 0, 0 },
            { 4, 0, 2, 5, 0 },
            { 8, 2, 0, 5, 9},
            { 0, 5, 5, 0, 4 },
            { 0, 0, 9, 4, 0 } 
        };
        Dijkstra_2dArray t = new Dijkstra_2dArray(); 
        t.dijkstra_SSSP(graph, 0);
    }
}
