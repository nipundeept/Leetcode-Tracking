class Solution {
public:
    int maximumLengthSubstring(string s) {
        int n = s.size();
        vector<int> freq(26);
        int left = 0, length = 0;
        for (int right = 0; right < n; right++) {
            char ch = s[right];
            freq[ch - 'a']++;
            while (freq[ch - 'a'] > 2) {
                freq[s[left] - 'a']--;
                left++;
            }
            length = max(length, right - left + 1);
        }
        return length;
    }
};