class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char key : map.keySet()) {
            maxHeap.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int val = map.get(ch);
            while (val != 0) {
                sb.append(ch);
                val--;
            }
        }
        return sb.toString();
    }
}