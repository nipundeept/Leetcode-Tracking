class Solution {
    public int minSteps(String s, String t) {
        int length = s.length(); // since length is same for both s and t

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (int i = 0; i < length; ++i) {
            freqS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < length; i++) {
            freqT[t.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            char ch1 = t.charAt(i);
            int getFreq = freqS[ch1 - 'a'];
            if (getFreq == 0) { // distinct element, so we add
                count++;
            }
            else if (freqT[ch1 - 'a'] - freqS[ch1 - 'a'] > 0) {
                count += freqT[ch1 - 'a'] - freqS[ch1 - 'a'];
                freqT[ch1 - 'a'] = -1;
            }
        }

        return count;
    }
}