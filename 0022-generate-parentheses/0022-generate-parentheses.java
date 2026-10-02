class Solution {
    class ParanInfo {
        String str;
        int leftCount;
        int rightCount;
        public ParanInfo(String str, int leftCount, int rightCount) {
            this.str = str;
            this.leftCount = leftCount;
            this.rightCount = rightCount;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<ParanInfo> queue = new LinkedList<>();
        queue.offer(new ParanInfo("(", 1, 0));
        while (!queue.isEmpty()) {
            ParanInfo curr = queue.poll();
            String strVal = curr.str; int left = curr.leftCount, right = curr.rightCount;
            if (strVal.length() == n * 2 && left == right) {
                result.add(strVal);
                continue;
            }
            if (left <= n) {
                queue.offer(new ParanInfo(strVal + "(" ,left + 1, right));
            }
            if (right < left) {
                queue.offer(new ParanInfo(strVal + ")" ,left , right + 1));
            }
        }

        return result;
    }
}