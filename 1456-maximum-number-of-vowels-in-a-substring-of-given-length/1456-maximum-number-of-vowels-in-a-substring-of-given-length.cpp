class Solution {
public:
    int maxVowels(string s, int k) {
        //sliding window of fixed size = k
        int ans = 0;
        //for first window (preparing the window)
        for (int i = 0; i < k; i++) {
            if (checkVowel(s[i])) {
                ans++;
            }
        }
        int curr = ans;
        //for next n - k windows
        for (int i = k; i < s.size(); i++){ 
            if (checkVowel(s[i - k])) {
                curr--;
            }
            if (checkVowel(s[i])) {
                curr++;
            }
            ans = max(ans, curr);
        }
        return ans;
    }

    bool checkVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
};