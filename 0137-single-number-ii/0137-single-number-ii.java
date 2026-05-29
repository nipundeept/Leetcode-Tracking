class Solution {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += ((num >> i) & 1);
            }
            arr[i] = sum;
        }
        int mul = 1; int num = 0;
        for (int i = 0; i < 32; i++) {
            num += mul * (arr[i] % 3);
            mul *= 2;
        }
        return num;
    }
}