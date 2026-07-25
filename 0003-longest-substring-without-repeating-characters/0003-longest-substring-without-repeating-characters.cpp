class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int l = 0, r = 0, ans = 0, n = s.size();
        unordered_set<char> set;
        while (r < n) {
            if (set.contains(s[r])) {
                while (set.contains(s[r])) {
                    set.erase(s[l]);
                    l++;
                }
            }
            else {
                set.insert(s[r]);
                ans = max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }
};