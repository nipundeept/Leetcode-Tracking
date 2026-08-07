class Solution {
public:
    //using monotonic stack to find the right and left boundaries of every element for the subarrays in which it will be minimum (using basic combinatorics), and to find its contribution in the sum.
    /* few optimisations and corrections
    * make one boundary strict and other non-strict
    * Integer overflow and modulus
    * Pass by value(for better performance)
    */
    int sumSubarrayMins(vector<int>& arr) {
        vector<int> pse = previousSmallerHelper(arr);
        vector<int> nse = nextSmallerHelper(arr);
        int n = arr.size();
        long long sum = 0;
        const int MOD = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            long long right_count = nse[i], left_count = pse[i];
            long long total_combinations = right_count * left_count;
            sum = (sum + (arr[i] * total_combinations % MOD)) % MOD;
        }
        return sum;
    }
    vector<int> previousSmallerHelper(const vector<int> &arr) { //this helper function returns the distances of previous smaller element for every current element
        int n = arr.size();
        vector<int> res(n);
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[i] <= arr[st.top()]) {
                st.pop();
            }
            res[i] = (st.empty()) ? i - (-1) : (i - st.top());
            st.push(i);
        }
        return res;
    }
    vector<int> nextSmallerHelper(const vector<int> &arr) { //this helper function returns the distances of next smaller element for every current element
        int n = arr.size();
        vector<int> res(n);
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] < arr[st.top()]) {
                st.pop();
            }
            res[i] = (st.empty()) ? n - i : (st.top() - i);
            st.push(i);
        }
        return res;
    }
};