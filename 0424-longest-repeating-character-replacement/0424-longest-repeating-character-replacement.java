class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26]; //stores the frequency of the alphabets
        int left = 0, right, res = 0;
        for (right = 0; right < n; right++) {
            freq[s.charAt(right) - 'A']++;
            while ((right - left + 1 - maxFrequency(freq)) > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    private int maxFrequency(int[] arr) {
        int freqMax = 0;
        for (int i = 0; i < 26; i++) {
            freqMax = Math.max(freqMax, arr[i]);
        }
        return freqMax;
    }
}