class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] totalDay = new int[366];
        int arriveA = getDays(arriveAlice);
        int leaveA = getDays(leaveAlice);
        int arriveB = getDays(arriveBob);
        int leaveB = getDays(leaveBob);
        for (int i = arriveA; i <= leaveA; i++) {
            totalDay[i]++;
        }
        int result = 0;
        for (int i = arriveB; i <= leaveB; i++) {
            if (totalDay[i] != 0) {
                result++;
            }
            totalDay[i]++;
        }

        return result;
    }

    private int getDays(String date) {
        int result = 0;
        //MM-DD format
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }
        if (result == 0) {
            return day;
        }

        return (result + day);
    }
}