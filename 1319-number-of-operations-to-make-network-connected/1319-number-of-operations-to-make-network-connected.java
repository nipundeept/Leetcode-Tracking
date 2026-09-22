class Solution {
    public int makeConnected(int n, int[][] connections) {
        int l = connections.length;
        if (l < n - 1) {
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < l; i++) {
                int u = connections[i][0];
                int v = connections[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
        }

        int operations = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                operations++;
                dfs(i, visited, adj);
            }
        }
        return operations - 1;
    }
    
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}