class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int currSum = 0, ballCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = boxes.charAt(i);
            currSum += ballCount;
            if (ch == '1') {
                ballCount++;
            }
            leftSum[i] = currSum;
        }

        currSum = 0; ballCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = boxes.charAt(i);
            currSum += ballCount;
            if (ch == '1') {
                ballCount++;
            }
            rightSum[i] = currSum;
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = leftSum[i] + rightSum[i];
        }

        return result;
    }
}