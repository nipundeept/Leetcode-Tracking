class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1' && i != j) {
                    sum += Math.abs(j - i);
                }
            }
            result[i] = sum;
        }

        return result;
    }
}