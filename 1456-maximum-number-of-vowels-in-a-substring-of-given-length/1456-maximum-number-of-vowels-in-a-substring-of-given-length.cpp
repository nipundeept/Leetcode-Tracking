class Solution {
public:
    int maxVowels(string s, int k) {
        //sliding window of fixed size = k
        int ans = 0;
        //for first window (preparing the window)
        for (int i = 0; i < k; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                ans++;
            }
        }
        int curr = ans;
        //for next n - k windows
        for (int i = k; i < s.size(); i++){ 
            if (s[i - k] == 'a' || s[i - k] == 'e' || s[i - k] == 'i' || s[i - k] == 'o' || s[i - k] == 'u') {
                curr--;
            }
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                curr++;
            }
            ans = max(ans, curr);
        }
        return ans;
    }
};