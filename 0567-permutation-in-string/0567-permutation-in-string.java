class Solution {
    //we need to compare the frequency of characters in s1 and in the sliding window (fixed size) of s2. if the frequencies are equal, we return true
    public boolean checkInclusion(String s1, String s2) {
        //missed an edge case
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1_freq = new int[26]; //storing the frequency of characters in string s1
        for (int k = 0; k < s1.length(); k++) {
            s1_freq[s1.charAt(k) - 'a']++;
        }
        int[] window_freq = new int[26];
        int window_size = s1.length(); //fixed size window (of length equal to string s1)
        int n = s2.length();
        int i = 0;
        for (; i < window_size; i++) {
            char ch = s2.charAt(i);
            window_freq[ch - 'a']++;
        }
        if (checkFrequency(s1_freq, window_freq)) {
            return true;
        }
        for (; i < n; i++) {
            char ch = s2.charAt(i);
            char ch2 = s2.charAt(i - window_size);
            window_freq[ch - 'a']++;
            window_freq[ch2 - 'a']--;
            if (checkFrequency(s1_freq, window_freq)) {
                return true;
            }
        }
        return false;

    }
    //helper function to check equality of frequency of characers in a1 and a2
    private boolean checkFrequency(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}