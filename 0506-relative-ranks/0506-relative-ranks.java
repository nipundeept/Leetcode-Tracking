class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = score[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;
        for (int num : temp) {
            map.put(num, i++);
        }
        String[] result = new String[n];
        for (i = 0; i < n; i++) {
            int x = map.get(score[i]);
            if (x == 1) {
                result[i] = "Gold Medal";
            }
            else if (x == 2) {
                result[i] = "Silver Medal";
            }
            else if (x == 3) {
                result[i] = "Bronze Medal";
            }
            else {
                result[i] = Integer.toString(x);
            }
        }
        return result;
    }
}