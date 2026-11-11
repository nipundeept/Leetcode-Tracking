int firstMissingPositive(int* nums, int numsSize) {
    // Optimal solution using index placement (Cyclic sort)
    int i, j, temp, correctIndex;
    i = 0;
    while (i < numsSize) {

        correctIndex = nums[i] - 1;
        if (nums[i] > 0 && nums[i] <= numsSize && nums[i] != nums[correctIndex]) {
            // Swap nums[i] with nums[correctIndex]
            temp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = temp;
        }

        else {
            i++;
        }
    }

    for (j = 0; j < numsSize; j++) {
        if (nums[j] != j + 1) {
            return j + 1;
        }
    }

    return numsSize + 1;

}