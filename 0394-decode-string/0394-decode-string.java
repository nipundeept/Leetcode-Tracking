class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<Integer> num_stack = new ArrayDeque<>();
        Deque<String> string_stack = new ArrayDeque<>();
        int curr_num = 0; String curr_str = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr_num = curr_num * 10 + (ch - '0');
            }
            else if (Character.isLowerCase(ch)) {
                curr_str += ch;
            }
            else if (ch == '[') {
                num_stack.push(curr_num);
                string_stack.push(curr_str);
                curr_num = 0;
                curr_str = "";
            }
            else {
                String formed = "";
                int t = num_stack.pop();
                while (t > 0) {
                    formed += curr_str;
                    t--;
                }
                curr_str = string_stack.pop() + formed;
            }
        }
        return curr_str;
    }
}