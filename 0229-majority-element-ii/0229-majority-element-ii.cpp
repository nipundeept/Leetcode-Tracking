class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> result;

        int cand1 = INT_MIN, cand2 = INT_MIN, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums[i];

            if (count1 == 0 && curr != cand2) {
                //since both of cand1 and cand2 can not have same elements, we have to set a condition that distinguishes them
                cand1 = curr;
                count1++;
            }
            else if (count2 == 0 && curr != cand1) {
                cand2 = curr;
                count2++;
            }
            else if (curr == cand1) count1++;
            else if (curr == cand2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        //Boyer-Moore voting algo gives us the potential candidates in the first pass, but they are not guaranteed, we have to check them manually in the second pass
        int threshold_freq = nums.size() / 3; //the required frequency must be strictly greater than this

        //reset the counters;
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == cand1) {
                count1++;
            }
            else if (num == cand2) {
                count2++;
            }
        }

        if (count1 > threshold_freq) {
            result.push_back(cand1);
        }
        if (count2 > threshold_freq) {
            result.push_back(cand2);
        }

        sort(result.begin(), result.end());

        return result;
    }
};