class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    adj.get(i).add(j);
                }
            }
        }
        int x = 0;
        for (List<Integer> list : adj) {
            result[x++] = list.size();
        }
        return result;
    }
}