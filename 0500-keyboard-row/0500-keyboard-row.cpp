class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        vector<string> res;
        unordered_set<char> set1, set2, set3;
        string s1 = "qwertyuiop", s2 = "asdfghjkl", s3 = "zxcvbnm";
        for (int i = 0; i < s1.size(); ++i) {
            set1.insert(s1[i]);
        }

        for (int i = 0; i < s2.size(); i++) {
            set2.insert(s2[i]);
        }

        for (int i = 0; i < s3.size(); i++) {
            set3.insert(s3[i]);
        }

        for (int i = 0; i < words.size(); ++i) {
            string s = words[i];
            if (checkSet(set1, s) || checkSet(set2, s) || checkSet(set3, s)) {
                res.push_back(s);
            }
        }

        return res;
    }

    bool checkSet(unordered_set<char> &set, string s) {
        for (int i = 0; i < s.size(); i++) {
            char ch = tolower(s[i]);
            if (!set.contains(ch)) {
                return false;
            }
        }

        return true;
    }
};