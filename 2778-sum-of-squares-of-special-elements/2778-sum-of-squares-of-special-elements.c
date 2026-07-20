int sumOfSquares(int* nums, int numsSize) {
    int i, n, k, sum;
    n = numsSize; k = 1; sum = 0;
    for (i = 0; i < n; i++) {
        if (n % (k++) == 0) {
            sum += (nums[i] * nums[i]);
        }
    }
    return sum;
}