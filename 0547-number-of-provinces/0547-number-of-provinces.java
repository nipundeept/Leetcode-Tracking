class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != j) && (isConnected[i][j] == 1)) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int province = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                province++;
                dfs(i, visited, adj);
            }
        }
        return province;

    }

    private void dfs(int n, boolean[] visited, List<List<Integer>> adj) {
        visited[n] = true;
        for (int neighbor : adj.get(n)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}