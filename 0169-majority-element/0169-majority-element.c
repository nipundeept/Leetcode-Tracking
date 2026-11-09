int majorityElement(int* nums, int numsSize) {
    // Optimal solution using Boyer - Moore Voting algorithm
    int count, candidate;
    count = 0; candidate = 0;
    for (int i = 0; i < numsSize; i++) {
        int current = *(nums + i);

        if (count == 0) {
            candidate = current;
        }
        if (current == candidate) {
            count++;
        }
        else {
            count--;
        }
    }

    return candidate;
}