class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                low++;
                high++;
            }
            else if (c == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;   // '*' ko ')' maan sakte hain
                high++;  // '*' ko '(' maan sakte hain
            }

            if (high < 0) {
                return false;
            }

            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}