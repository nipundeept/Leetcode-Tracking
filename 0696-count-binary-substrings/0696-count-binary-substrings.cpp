class Solution {
public:
    int countBinarySubstrings(string s) {
        int n = s.size();
        vector<int> group;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) {
                count++;
            }
            else {
                group.push_back(count);
                count = 1;
            }
        }
        group.push_back(count);
        int result = 0;
        n = group.size();
        for (int i = 0; i < n - 1; i++) {
            result += min(group[i], group[i + 1]);
        }
        return result;
    }
};