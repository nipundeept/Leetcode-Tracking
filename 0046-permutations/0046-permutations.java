class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, path, result);
        
        return result;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            list.add(nums[i]); //add the choice and set visited to true for the current ongoing path
            visited[i] = true;
            helper(nums, visited, list, result);

            //backtrack to the previous state
            list.removeLast();
            visited[i] = false;
        }
    }
}