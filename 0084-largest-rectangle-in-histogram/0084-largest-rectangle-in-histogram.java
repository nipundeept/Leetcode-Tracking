class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        //brute-force
        int n = heights.length; int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int local_area = 0, min_val = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min_val = Math.min(min_val, heights[j]);
                local_area = min_val * (j - i + 1);
                maxArea = Math.max(maxArea, local_area);
            }
        }
        return maxArea;
        */
        //optimal approach (using monotonic stack)
        //for every bar, we have to compute its next smaller element and previous smaller element, because this is the boundary condition for the bar (the area would change, once a bar smaller than the current is found), we compute the area until the current bar remains the minimum bar in the rectangle and then store it and compare it accordingly with other bars.
        //width = next smaller element - previous smaller element - 1
        //area = width * height[i]
        int[] previousSmaller = previousSmallerElement(heights);
        int[] nextSmaller = nextSmallerElement(heights);
        int n = heights.length, maxArea = 0;
        for (int i = 0; i < n; i++) {
            //calculating width
            int width = nextSmaller[i] - previousSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    //this function returns the indices of the previous Smaller Element for all the current elements
    int[] previousSmallerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); //monotonically increasing stack
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            result[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }
    int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); //monotonically increasing stack
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            result[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        return result;
    }
}