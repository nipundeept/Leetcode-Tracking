class Solution {
public:
    string convertDateToBinary(string date) {
        int s1 = stoi(date.substr(0, 4));
        int s2 = stoi(date.substr(5, 2));
        int s3 = stoi(date.substr(8, 2));
        string str1 = toBinary(s1);
        string str2 = toBinary(s2);
        string str3 = toBinary(s3);
        return (str1 + '-' + str2 + '-' + str3);
    }
    string toBinary(int num) {
        string str = "";
        while (num != 0) {
            str += ('0' + (num % 2));
            num = num >> 1;
        }
        reverse (str.begin(), str.end());
        return str;
    }
};