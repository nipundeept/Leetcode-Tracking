class StockSpanner {
    private static class Pair {
        int price;
        int index;
        Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
    Deque<Pair> st;
    int day;
    public StockSpanner() {
        st = new ArrayDeque<>();
        day = 0;
    }

    public int next(int price) {
        int span;
        while (!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }
        span = (st.isEmpty()) ? day + 1 : day - st.peek().index;
        st.push(new Pair(price, day));
        day++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */