class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();

        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        for (int i = 0; i < n; i++) {
            boolean checkSafe = dfs(i, graph, visited, pathVisited);
            if (!checkSafe) {
                list.add(i);
            }
        }

        return list;
    }

    //using 2 array dfs cycle detection approach..if any of the path from a single node eventually contains a cycle, that node cannot be the safe state

    //function returns true if cycle is detected in any of the path from that node(so that node cannot be safe)

    //function returns false if cycle is not detected in all of the paths leading from the node(therefore node is safe)

    private boolean dfs(int node, int[][] graph, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int neighbor : graph[node]) {
            if (visited[neighbor] == 0) { //if it is still unvisited, explore

                boolean checkCycle = dfs(neighbor, graph, visited, pathVisited);
                if (checkCycle) {
                    return true;
                }
            }

            else if (pathVisited[neighbor] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0; //backtrack from the current path and set it to unvisited
        return false;
    }
}