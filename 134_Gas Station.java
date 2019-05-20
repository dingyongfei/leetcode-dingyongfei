//分为2步：
1. 确定本题是否有答案（即返回值不是 -1）;   
2. 找出出发点。

（本题方法论: 牢记!! 
1. 验证有没有(total += gas[i] - cost[i]; } if (total < 0) { return -1;) 
2.找出答案(tank += gas[i] - cost[i]; if (tank < 0) { start = i + 1; tank = 0;) ）
class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		/**verify
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
		}
		if (total < 0) {
			return -1;
		}
*/

		int tank = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		return start;
	}
}
