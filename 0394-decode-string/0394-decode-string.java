class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<Integer> num_stack = new ArrayDeque<>();
        Deque<StringBuilder> string_stack = new ArrayDeque<>();
        int curr_num = 0; StringBuilder curr_str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr_num = curr_num * 10 + (ch - '0');
            }
            else if (Character.isLowerCase(ch)) {
                curr_str.append(ch);
            }
            else if (ch == '[') {
                num_stack.push(curr_num);
                string_stack.push(curr_str);
                curr_num = 0;
                curr_str = new StringBuilder();
            }
            else {
                StringBuilder formed = new StringBuilder();
                int t = num_stack.pop();
                while (t > 0) {
                    formed.append(curr_str);
                    t--;
                }
                curr_str = string_stack.pop().append(formed);
            }
        }
        return curr_str.toString();
    }
}