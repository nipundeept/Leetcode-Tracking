class Solution {
public:
    string smallestPalindrome(string s) {
        //construct the string using left + middle + reverse(left)
        string left, middle;
        vector<int> freq(26);
        int n = s.size();
        for (int i = 0; i < n; i++) {
            freq[s[i] - 'a']++; //storing the frequency of each character
        }
        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            int construct = f / 2;
            if (f % 2 != 0) {
                middle = 'a' + i;
            }
            while (construct != 0) {
                char corresp = 'a' + i;
                left += corresp;
                construct--;
            }
        }
        string right = left;
        reverse(right.begin(), right.end());
        return left + middle + right;
    }
};