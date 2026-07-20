class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>(); //creating a map to store and update elements and their indices in array nums
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //to get the index of the array instantly without searching, we store it in map
        }
        for (int i = 0; i < operations.length; i++) {
            int v1 = operations[i][0], v2 = operations[i][1];
            int index = map.get(v1); //get the current index of key in operation array
            nums[index] = v2; //replace it with the value
            //update the new map by replacing the old value with the switched value
            map.remove(v1);
            map.put(v2, index);
        }
        return nums;
    }
}