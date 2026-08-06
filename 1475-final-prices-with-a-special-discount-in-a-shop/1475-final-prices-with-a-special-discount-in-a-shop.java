class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int value = prices[i];
            while (!st.isEmpty() && value < st.peek()) {
                st.pop();
            }
            result[i] = (st.isEmpty()) ? 0 : st.peek();
            st.push(value);
        }
        for (int i = 0; i < n; i++) {
            result[i] = prices[i] - result[i];
        }
        return result;
    }
}