class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);
        int first = findFirst(nums, target);
        if (first == -1) {
            return result;
        }

        int last = findLast(nums, target);
        for (int i = first; i <= last; i++) {
            result.add(i);
        }

        return result;
    }

    int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }


    int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}