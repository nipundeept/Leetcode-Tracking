class Solution {
public:
    int maximumLengthSubstring(string s) {
        int n = s.size();
        vector<int> freq(26);
        int left = 0, length = 0;
        for (int right = 0; right < n; right++) {
            int k = s[right] - 'a';
            freq[k]++;
            while (freq[k] > 2) {
                freq[s[left] - 'a']--;
                left++;
            }
            length = max(length, right - left + 1);
        }
        return length;
    }
};