/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {

    int *rightPrefix, *leftPrefix, *result, curr;
    result = malloc(sizeof(int) * numsSize);
    leftPrefix = malloc(sizeof(int) * numsSize);
    rightPrefix = malloc(sizeof(int) * numsSize);


    curr = 1;
    for (int i = 0; i < numsSize; i++) {
        leftPrefix[i] = curr;
        curr = curr * nums[i];
    }

    //reset curr to 1
    curr = 1;
    for (int i = numsSize - 1; i >= 0; i--) {
        rightPrefix[i] = curr;
        curr = curr * nums[i];
    }

    for (int i = 0; i < numsSize; i++) {
        result[i] = leftPrefix[i] * rightPrefix[i];
    }
    
    free(leftPrefix);
    free(rightPrefix);
    *returnSize = numsSize;

    return result;

}