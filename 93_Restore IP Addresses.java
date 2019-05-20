class Solution {
	List<String> list = new ArrayList<String>();

	public List<String> restoreIpAddresses(String str) {
		if (str.length() > 12)
			return list;
		process("", str, 0);
		return list;
	}

	public void process(String prefix, String str, int index) {
        if(str.isEmpty()) {           //注意，这里一定是要判断“s.isEmpty()”,包含了三种情况：
            if(index==4) {          //1.s过长，直接return； 2.s过短，不够划分，直接return 3.s正好划分完，满足条件，加入list，return。
                list.add(prefix.substring(1));
            } 
            return;
        }
        //Fuck!!!!  是” i <= (str.charAt(0)==’0’?0:2) “, 不是” i<=str.charAt(0)=='0' ? 0 : 2 “, 也不能写成” i<=(str.charAt(0)=='0') ? 0 : 2 “ !!! 都会导致类型不匹配！ 必须永远将三目运算表达式写成一个整体！即永远要将一整个三目运算符用括号括起来！！！
        for(int i=0;i<=(str.charAt(0)=='0'?0:2)&&i+1<=str.length();i++) {    //注意，s.substring(beginIndex, endIndex)方法中, "endIndex可以等于s.length()"
            String goal = str.substring(0, i+1);
		/*if(Integer.valueOf(goal) > 255) {
                continue;
            }*/
            if(Integer.valueOf(goal) <= 255) {
                process(prefix+"."+goal,  str.substring(i+1), index+1);
            }
        }
    }
