class Solution {
    /* 
    Intuition : We could use all indices in arrays as pointers, directing us to the next position in the array, since every single value is guaranteed to be an integer between 1 and n.
    We could have negated those values at indices and found the duplicate, but the constraint here is no array modification. 
    We use cycle detection here using Floyd's Turtle and Hare algorithm (slow and fast pointers).
    */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //finding the intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        //once they have collided, we find the duplicate number , keeping fast pointer exactly at the point of collision and set slow to 0
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        //both pointers collided again
        return fast; //or slow
    }
}