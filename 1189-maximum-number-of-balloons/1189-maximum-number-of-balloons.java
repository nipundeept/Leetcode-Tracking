class Solution {
    public int maxNumberOfBalloons(String text) {
        int b_freq = 0, a_freq = 0, l_freq = 0, o_freq = 0, n_freq = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'b')
                b_freq++;
            else if (ch == 'a')
                a_freq++;
            else if (ch == 'l')
                l_freq++;
            else if (ch == 'o')
                o_freq++;
            else if (ch == 'n')
                n_freq++;
        }
        l_freq = l_freq / 2;
        o_freq = o_freq / 2;
        int min = Math.min(b_freq, Math.min(a_freq, Math.min(l_freq, Math.min(o_freq, n_freq))));
        return min;
    }
}