class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.size();
        int left = 0, count = 0, min_length = 101;
        string result = "";
        for (int right = 0; right < n; right++) {
            char ch = s[right];
            if (ch == '1') {
                count++;
            }
            while (count > k) {
                if (s[left] == '1') {
                    count--;
                }
                left++;
            }
            while (count == k && s[left] == '0') {
                left++; //shrinking window by removing unnecessary 0s from the beginning if it has exactly k number of ones
            }
            if (count == k) {
                string curr = s.substr(left, right - left + 1);
                int sub_size = right - left + 1;
                if (sub_size < min_length || (sub_size == min_length) && (curr < result)) {
                    result = curr;
                    min_length = sub_size;
                }
            }
            
        }
        return result;
    }  
};