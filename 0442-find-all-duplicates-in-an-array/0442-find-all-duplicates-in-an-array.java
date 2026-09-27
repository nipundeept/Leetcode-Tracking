class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        dfs(nums, result, visited, n - 1);
        return result;
    }
    private void dfs(int[] arr, List<Integer> result, boolean[] visited, int n) {
        if (n < 0) {
            return;
        }
        if (visited[arr[n]]) {
            result.add(arr[n]);
        }
        visited[arr[n]] = true;
        dfs(arr, result, visited, n - 1);
    }
}