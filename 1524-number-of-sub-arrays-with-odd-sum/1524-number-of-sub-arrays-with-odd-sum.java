class Solution {
    public int numOfSubarrays(int[] arr) {
        
        final int MOD = (int) 1e9 + 7;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>(); // stores the parity
        map.put(0, 1);

        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int parity = sum % 2;
            count = count % MOD + map.getOrDefault((1 - parity), 0) % MOD;
            map.put(parity, map.getOrDefault(parity, 0) + 1);
        }

        return count;
    }
}