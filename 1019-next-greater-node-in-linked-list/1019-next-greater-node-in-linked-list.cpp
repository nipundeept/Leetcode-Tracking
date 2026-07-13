/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {
        stack<int> st;
        vector<int> arr; //copying all the elements in a list
        for (ListNode* temp = head; temp != nullptr; temp = temp->next) {
            arr.push_back(temp->val);
        }
        vector<int> res(arr.size(), 0); 
        for (int i = 0; i < arr.size(); i++) {
            int curr = arr[i];
            while (!st.empty() && curr > arr[st.top()]) {
                int idx = st.top();
                st.pop();
                res[idx] = curr;
            }
            st.push(i);
        }
        return res;
    }
};