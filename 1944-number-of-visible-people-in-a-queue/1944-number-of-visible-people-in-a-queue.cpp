class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        int n = heights.size();
        vector<int> res(n, 0);
        /*
        //bruteforce
        for (int i = 0; i < n; i++) {
            int maxHeight = 0;
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > maxHeight) {
                    maxHeight = heights[j];
                    res[i]++;
                }
                if (heights[j] > heights[i]) {
                    break;
                }
            }
        }
        return res;
        */
        //optimal solution using monotonic stack
        //stack stores the useful heights for the upcoming elements towards the left(as we are traversing from right to left)
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            int height = heights[i];
            while (!st.empty() && height > st.top()) {
                res[i]++;
                st.pop();
            }
            if (!st.empty()) {
                res[i]++;
            }
            st.push(height);
        }
        return res;
    }
};