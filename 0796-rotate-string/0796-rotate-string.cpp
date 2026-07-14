class Solution {
public:
    bool rotateString(string s, string goal) {
        //if the sizes are different, goal definitely could not be a rotated string
        if (s.size() != goal.size()) {
            return false;
        }
        string check = s + s; //created a string consisting of doubled s
        //this string will consist of rotated values as a substring, we just need to check if goal is a possible substring here or not
        if (check.find(goal) != string::npos) { //goal exists in the given string
            return true; 
        }
        return false;
    }
};