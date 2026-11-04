class Solution {
public:
    string reverseVowels(string s) {
        int left = 0, right = s.size() - 1;
        while (left < right) {
            if (isVowel(s[left]) && isVowel(s[right])) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++; right--;
            }
            if (!isVowel(s[left])) {
                left++;
            }
            if (!isVowel(s[right])) {
                right--;
            }
        }

        return s;
    }

    bool isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        
        return false;
    }
};