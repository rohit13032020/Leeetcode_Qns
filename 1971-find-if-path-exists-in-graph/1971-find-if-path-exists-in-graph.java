
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    public boolean dfs(int source, int destination,
                       List<Integer>[] graph, boolean[] visited) {

        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int neighbor : graph[source]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
