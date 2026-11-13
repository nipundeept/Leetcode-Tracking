class Solution {
public:
    int maxArea(vector<int>& height) {
    int left, right, amount;
    left = 0; right = height.size() - 1; amount = 0;
    // we approach the pointers towards each other (for quicker access of the water levels), take minimum of the two and multiply with the pointers' distance
    while (left < right) {

        int length = min(height[left], height[right]);
        int area = length * (right - left);
        amount = max(area, amount);
        if (height[left] < height[right]) {
            left++;
        }
        else right--;
    }

    return amount;
    }
};