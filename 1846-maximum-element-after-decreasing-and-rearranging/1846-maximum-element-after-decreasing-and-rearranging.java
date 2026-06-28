class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //We are required to return the maximum possible value of element, therefore we can use greedy method by sorting the array and then changing the required position
        Arrays.sort(arr); arr[0] = 1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}