int sumIndicesWithKSetBits(int* nums, int numsSize, int k) {
    int temp, count, result;
    result = 0;
    for (int i = 0; i < numsSize; i++) {
        temp = i; count = 0;
        while (temp != 0) {
            count = (temp & 1) ? (count + 1) : count;
            temp = temp >> 1;
        }

        if (count == k) {
            result += nums[i];
        }
    }

    return result;
}

int 