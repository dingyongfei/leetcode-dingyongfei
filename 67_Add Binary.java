class Solution {
	public String addBinary(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
	    while (i >= 0 || j >= 0) {
            int num1 = (i >= 0 ? a.charAt(i--) - '0' : 0);
            int num2 = (j > =0 ? b.charAt(j--) - '0' : 0);
            sum = num1 + num2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        /*
        while(i>=0||j>=0) {
            sum = carry;       //因为a和b的长度不同，i和j分情况讨论  ---> 所以注意这里sum的赋值技巧，直接让"sum==carry;".
            if(i>=0) sum+=a.charAt(i--) - '0';
            if(j>=0) sum+=b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
*/
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();            //使用StringBuilder类的reverse() 方法（注意，不是String类，String类没有reverse()方法）
    }
}
