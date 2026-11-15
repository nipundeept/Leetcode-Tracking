class Solution {
    public int numOfSubarrays(int[] arr) {
        
        final int MOD = (int) 1e9 + 7;
        int n = arr.length;
        
        int[] parityStorage = new int[2];
        parityStorage[0] = 1;

        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int parity = sum % 2;
            count = count % MOD + parityStorage[1 - parity] % MOD;
            parityStorage[parity]++;
        }

        return count;
    }
}