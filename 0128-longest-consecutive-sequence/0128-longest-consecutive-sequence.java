/*
To optimise the solution to this problem, we can implement HashSet, they have constant O(1) look-up time.
*/
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = 0;
        for (int num : set) {
            //if num is not the first element of the sequence, we skip
            if (set.contains(num - 1)) {
                continue;
            }
            int currStreak = 0;
            while(set.contains(num)) {
                currStreak++;
                num++;
            }
            maxStreak = Math.max(maxStreak, currStreak);
        }

        return maxStreak;
    }
}