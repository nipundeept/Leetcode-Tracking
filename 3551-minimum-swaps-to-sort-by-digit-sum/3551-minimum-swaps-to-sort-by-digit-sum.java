class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] sortedTemp = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedTemp[i] = nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(sortedTemp, (a, b) -> {
            int sum1 = digitsSum(a), sum2 = digitsSum(b);
            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return Integer.compare(a, b);
        });

        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = sortedTemp[i];
        }

        int swap = 0;
        
        for (int i = 0; i < n; i++) {
            while(nums[i] != sorted[i]) {
                int correctIndex = map.get(sorted[i]);

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

                //updating the map
                map.put(nums[i], i);
                map.put(nums[correctIndex], correctIndex);

                swap++;
            }
        }

        return swap;
    }
    
    int digitsSum (int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}