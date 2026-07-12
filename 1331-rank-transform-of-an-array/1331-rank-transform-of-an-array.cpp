class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        if (arr.size() == 0) {
            return arr;
        }
        vector<int> copy(arr);
        unordered_map<int, int> map;
        sort(copy.begin(), copy.end());
        map.insert({copy[0], 1});
        int k = 2;
        for (int i = 1; i < copy.size(); i++) {
            if (copy[i] != copy[i - 1]) {
                map.insert({copy[i], k++});
            }
        }
        vector<int> res;
        for (int i = 0; i < arr.size(); i++) {
            res.push_back(map[arr[i]]);
        }
        return res;
    }
};