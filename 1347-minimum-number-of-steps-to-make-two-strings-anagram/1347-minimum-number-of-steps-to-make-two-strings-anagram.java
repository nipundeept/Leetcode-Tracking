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

    /*
    We can solve this using just one frequency array:
    1. Increment the frequency for every character in s.
    2. Decrement the frequency for every character in t.
    3. Sum the positive deficits in t relative to s—equivalently, count how many characters in t must be replaced.
    class Solution {
        public int minSteps(String s, String t) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
                freq[t.charAt(i) - 'a']--;
            }
            int count = 0;
            for (int f : freq) {
                if (f > 0) {
                    count += f;
                }
            }
            return count;
        }
    }
    */