class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put((long) num, frequencies.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 1;

        // Special handling for 1
        if (frequencies.containsKey(1L)) {
            int ones = frequencies.get(1L);

            if (ones % 2 == 0)
                maxLength = Math.max(maxLength, ones - 1);
            else
                maxLength = Math.max(maxLength, ones);
        }

        for (long start : frequencies.keySet()) {

            if (start == 1)
                continue;

            if (frequencies.get(start) < 2)
                continue;

            int currentLength = 2;
            long current = start * start;

            while (frequencies.containsKey(current) && frequencies.get(current) >= 2) {
                currentLength += 2;

                if (current > (long) Integer.MAX_VALUE * Integer.MAX_VALUE)
                    break;

                current = current * current;
            }

            if (frequencies.containsKey(current)) {
                currentLength += 1;
            } else {
                currentLength -= 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}