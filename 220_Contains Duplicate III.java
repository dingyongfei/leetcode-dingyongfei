// 使用TreeSet（基于红黑树的实现，key是按序组织的）, Treeset和TreeMap的任何操作的时间复杂度都是log(N) ! 
// ceiling(arg):如果不存在的话，返回刚比arg大的数（存在的话返回arg自身）; floor(arg):如果不存在的话，返回刚比arg小的数(存在的话返回arg).

// 总体思路和写法和上一题是一样的。

/**  写法一
// 2nd .防止溢出版本
class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove((long) nums[i - 1 - k]);        // 1.这两处也要转成long类型, 因为TreeSet<Long> 是Long 类型的 !!
			}
			long num = nums[i];                 //注意，一定要先将当前元素先转换成long类型，后续才能进行 floor >= num 和 ceiling <= num 的比较操作！ 否则依然存在溢出问题！！
			Long floor = set.floor((long) (num + t));
			Long ceiling = set.ceiling((long) (num - t));
			if (floor != null && floor >= num || ceiling != null && ceiling <= num) {
				return true;
			}
			set.add((long) num);                             // 2.这两处也要转成long类型, 因为TreeSet<Long> 是Long 类型的 !!

		}
		return false;
	}
}
*/

// 写法二
class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove((long) nums[i - 1 - k]);        // 1.这两处也要转成long类型, 因为TreeSet<Long> 是Long 类型的 !!
			}

			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);

			if (floor != null && Math.abs(nums[i] - floor) <= t || 
				ceiling != null && Math.abs(ceiling - nums[i]) <= t) {
				return true;
			}
			set.add((long) num);                             // 2.这两处也要转成long类型, 因为TreeSet<Long> 是Long 类型的 !!
		}
		return false;
	}
}
