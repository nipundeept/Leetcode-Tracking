class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int atMostT = slidingWindowHelper(answerKey, 'T', k);
        int atMostF = slidingWindowHelper(answerKey, 'F', k);
        return max(atMostT, atMostF);
    }
    //helper function to evaluate the largest subarray containing at most k characters in a string
    int slidingWindowHelper(string s, char ch, int k) {
        int curr_count = 0, n = s.size(), max_length = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char curr_ch = s[right];
            if (curr_ch == ch) {
                curr_count++;
            }
            while (curr_count > k) {
                if (s[left] == ch) {
                    curr_count--;
                }
                left++;
            }
            max_length = max(max_length, right - left + 1);
        }
        return max_length;
    }
};