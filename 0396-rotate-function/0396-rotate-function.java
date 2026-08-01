class Solution {
    public int maxRotateFunction(int[] nums) {
      //obtaining using recurrence relation
      // F(k) = F(k-1) + sum - n * lastElement
      int n = nums.length;
      long sum = 0; long ans;
      for (int num : nums) {
        sum += num;
      }
      //calculatig f(0)
      long f_0 = 0;
      for (int i = 0; i < n; i++) {
        f_0 += (long)i * nums[i];
      }
      ans = f_0;
      for (int i = 1; i < n; i++) {
        int last = nums[n - i];
        f_0 = f_0 + (long)sum - n * last;
        ans = Math.max(ans, f_0);
      }
      return (int)ans;
    }
}