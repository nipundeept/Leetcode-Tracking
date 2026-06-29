class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Map<Integer, Integer> map = new HashMap<>();
         int[] nge_arr = nge(nums2);
         for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nge_arr[i]);
         }
         int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = map.get(nums1[i]);
            }
         return result;
    }

    int[] nge(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        //stack will contain the latest update of the element which has the potential to be the next greater element
        for (int i = arr.length - 1; i >= 0; i--) { //we traverse the array from right to left
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop(); //pop until we are sure that the element on the peek of the stack is greater than the current element. If it does not exist, stack will be empty by the end of this loop.
            }
            result[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}