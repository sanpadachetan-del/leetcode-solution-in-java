class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while(i<n && s.charAt(i)== ' ')
        {
            i++;

        }
        int sign = 1;
        if(i<n && (s.charAt(i)== '+' || s.charAt(i)== '-')){
            if(s.charAt(i)== '-'){
                sign = -1;
            }
            i++;
        }
        long num = 0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i) <= '9'){
            num = num *10 + (s.charAt(i)- '0');
            if(sign == 1 && num>2147483647L){
                return 2147483647;
            }
            if(sign == -1 && -num < -2147483648L){
                return -2147483648;
            }
            i++;

        } 
        return(int)(sign*num);

    }
}