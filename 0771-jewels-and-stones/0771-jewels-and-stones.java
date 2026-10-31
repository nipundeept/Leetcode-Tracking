class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n = jewels.length(), result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(jewels.charAt(i));
        }

        n = stones.length();
        for (int i = 0; i < n; i++) {
            if (set.contains(stones.charAt(i))) {
                result++;
            }
        }

        return result;
    }
}