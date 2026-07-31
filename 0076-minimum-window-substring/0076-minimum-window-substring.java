class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        String res = "";
        int min_length = Integer.MAX_VALUE;
        int left = 0, formed = 0, required = 0; 
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!need.containsKey(ch)) {
                required++; //contains the count of distinct characters in t
            }
            need.put(ch, need.getOrDefault(ch, 0) + 1); //storing the frequency of characters of string t in the map
        }
        int n = s.length();
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch)) {
                if (window.get(ch).intValue() == need.get(ch).intValue()) { //if frequency of the character is equal in both the maps, we increment the value of formed by 1
                formed++;
                }
            }
            //shrinking the window while it is valid
            while (formed == required) {
                char ch2 = s.charAt(left);
                if ((right - left + 1) < min_length) { //if the current window is strictly greater than previous window
                    min_length = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window.put(ch2, window.getOrDefault(ch2, 0) - 1);
                if (need.containsKey(ch2)) {
                    if (window.get(ch2) < need.get(ch2)) {
                        formed--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}