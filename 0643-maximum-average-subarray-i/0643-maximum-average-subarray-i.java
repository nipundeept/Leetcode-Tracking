class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) { //Storing the sum of 1st window and assuming it to be maxSum
            currentSum += nums[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < nums.length; i++) { //traversing through the remaining elements
            currentSum = currentSum + nums[i] - nums[i - k]; //adding the upcoming element to the currentSum and simulatenously deleting the previous element which popped out in the new window.
            maxSum = Math.max(maxSum, currentSum); //stores the maximum sum of the elements so far
        }
        return (double)maxSum / k;
    }
}