class Solution {
    public int totalFruit(int[] fruits) {
        //sliding window (dynamic)
        //expand the window until it's valid, shrink if the window is invalid until it is valid again
        //if the window is valid, update the required answer
        //in this question, we need to find a maximum subarray two distinct numbers
        int max = 0, l = 0, r = 0, n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>(); //to store the frequency of fruits, we need to return the valid sum of frequency of each fruit (valid means map size should not exceed two)
        while (r < n) {
            //add the current value to the map
            map.put(fruits[r], (map.getOrDefault(fruits[r], 0)) + 1);
            //represents an invalid window (if the map size increases beyond 2)
            while (map.size() > 2) { //shrink it to get not more than 2
                map.put(fruits[l],(map.get(fruits[l]) - 1)); //decrease the frequency of fruits[left] in the map
                if (map.get(fruits[l]) == 0) { //if its frequency is 0, remove it from the map
                    map.remove(fruits[l]);
                }
                l++;
            }
            //after the above iterations, it is gauranteed to have a valid window again
        max = Math.max(max, r - l + 1); //update the answer
        r++; //expand the current window (because it's valid)
        }
    return max;
    }
}