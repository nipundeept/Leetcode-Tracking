class Solution {
public:
    int reverseDegree(string s) {
        int sum = 0, i = 1;
        for (char ch : s) {
            int index = 27 - (ch - 96);
            sum += (index * i++);
        }
        return sum;
    }
};