class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] map = new char[26];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map[ch - 'a']++; //stores frequency of characters
        }
        int b = map['b' - 'a']; //frequency of b
        int a = map['a' - 'a']; //frequency of a
        int l = map['l' - 'a'] / 2; //frequency of l
        int o = map['o' - 'a'] / 2; //frequency of o
        int n = map['n' - 'a']; //frequency of n
        int min_words = Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        return min_words;
    }
}