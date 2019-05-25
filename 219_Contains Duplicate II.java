//写法一
// 用Set维护一个滑动窗口即可。
// 本题中, 因为” the absolute difference between i and j is at most k.”, 窗口值 w 的大小相当于” k + 1 ” !!!  , 剩下的套用滑动窗口模型即可。
// 滑动窗口模型：先过滤过期值, 再处理 ” 此时大小等于指定值w “的窗口中的结果。
class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {                  // i和j距离最大不超过k, 即窗口内最多能装k + 1个元素！
				set.remove(nums[i - 1 - k]);           // (因为i ~ j之间有j – i -1个元素)
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}

// 写法二
// 套用滑动窗口模型搞一遍
class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		int w = k + 1;                        // w为窗口大小
		for (int i = 0; i < nums.length; i++) {
			if (i >= w) {
				set.remove(nums[i - w]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}
