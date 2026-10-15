class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        dfs(n - 1, 0, adj, new ArrayList<>());
        System.out.println(result);

        return result;

    }

    private void dfs(int n, int node, List<List<Integer>> adj, List<Integer> path) {

        path.add(node);

        if (adj.get(node).size() == 0 && path.get(path.size() - 1) == n) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (path.get(path.size() - 1) == n) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int neighbor : adj.get(node)) {
            dfs(n, neighbor, adj, path);
        }
        path.removeLast();
    }
}