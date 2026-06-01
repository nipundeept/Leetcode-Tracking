class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> result;
        for (int i = 0; i < candies.size(); i++) {
            int elem = candies[i] + extraCandies;
            int maxVal = elem;
            for (int j = 0; j < candies.size(); j++) maxVal = max(candies[j], maxVal);
            if (maxVal == elem) result.push_back(true);
            else result.push_back(false);
        }
        return result;
    }
};