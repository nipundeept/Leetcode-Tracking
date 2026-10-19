class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] check = new int[n];
        Arrays.fill(check, -1);

        for (int i = 0; i < n; i++) {
            if (check[i] == -1) {
                if (!dfs(graph, i, check)) {
                      return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int[] check) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        check[node] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph[curr]) {
                // if neighbor is still unvisited, visit it and add it to the queue
                if (check[neighbor] == -1) {
                    check[neighbor] = 1 - check[curr];
                    queue.offer(neighbor);
                }
                // if it is visited and its value is equal to the current's value, we immediately return false
                else if (check[neighbor] == check[curr]) {
                    return false;
                }
            }
        }

        return true;
    }
}