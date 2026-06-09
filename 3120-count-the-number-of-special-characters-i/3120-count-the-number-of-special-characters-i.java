class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> upper = new HashSet<>();
        Set<Character> lower = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch))
                lower.add(ch);
            else
                upper.add(Character.toLowerCase(ch));
        }
        int count = 0;
        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}