class Solution {
    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length + 1];
        res[0] = 0; //starts from 0
        int sum = 0, max = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            res[i + 1] = sum;
            max = Math.max(max, sum);
        }
        return max;
    }
}