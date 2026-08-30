import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> invalid = new HashSet<>();

        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // We are starting a new block
            if (num != prev) {
                // If this number appeared in an earlier block,
                // it is no longer special
                if (seen.contains(num)) {
                    invalid.add(num);
                }

                seen.add(prev);
            }

            prev = num;
        }

        // Add the final block's number
        seen.add(prev);

        return seen.size() - invalid.size();
    }
}