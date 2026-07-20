class Solution {
    /*
    [1,2,4,6] and operations are [[1,3], [4,7], [3,8]]
    initially storing [1,0],[2,1],[4,2],[6,3] in map (to get index of an element faster without searching it)
    Now, iterating through operations array :
    [1,3] => replace element 1 with 3
    so get the index of element 1, viz 0
    replace nums[0] with 3, the updated array becomes [3,2,4,6]
    and update the map by removing that element 1 with newly added element in its replacement [3,0], therefore updated map becomes [3,0],[2,1],[4,2],[6,3]
    --------------------------------------------------------------------------------------------------------
    for the next query, we have [4,7]
    find the index of 4 in nums (viz, 2) and replace nums[2] with 7 and update the map
    new array : [3,2,7,6] and updated map becomes [3,0],[2,1],[7,2],[6,3]
    --------------------------------------------------------------------------------------------------------
     for the next query, we have [3,8]
     find the index of 3 in nums (viz, 0) and replace nums[0] with 8 and update the map
     new array : [8,2,7,6] and updated map becomes [8,0],[2,1],[7,2],[6,3]
     and then return the final array
    */
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