class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();
        //bruteforce : O(n^3) 
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; //first digit of the number cannot be zero
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && k != i) {
                        int num = 100 * digits[i] + 10 * digits[j] + digits[k];
                        if ((num & 1) == 0)
                            set.add(num);
                    }
                }
            }
        }
        return set.size();
    }
}