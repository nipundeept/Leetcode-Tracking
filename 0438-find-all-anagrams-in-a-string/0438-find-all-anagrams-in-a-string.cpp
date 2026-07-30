class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        //edge case
        if(p.size() > s.size()) {
            return {};
        }
        int k = p.size(); //size of the window
        vector<int> freq_p(26);
        for (int i = 0; i < k; i++) {
            freq_p[p[i] - 'a']++;
        }
        vector<int> currWindow_freq(26);
        vector<int> res;
        for (int i = 0; i < k; i++) {
            currWindow_freq[s[i] - 'a']++;
        }
        if (hasEqualFrequency(currWindow_freq, freq_p)) {
            res.push_back(0);
        }
        int n = s.size();
        for (int i = k; i < n; i++) {
            currWindow_freq[s[i] - 'a']++;
            currWindow_freq[s[i - k] - 'a']--;
            if (hasEqualFrequency(currWindow_freq, freq_p)) {
            res.push_back(i - k + 1);
        }
    }
    return res;
    }
    bool hasEqualFrequency(vector<int>&a, vector<int>&b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
};