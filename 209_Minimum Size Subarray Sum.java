//和” 76. Minimum Window Substring ”有些类似，应该对比着看看。//注：本题非常类似于 “zuochengyun 未排序正数数组中累加和为给定值的最长子数组长度” ！
//子数组问题：注意，本题是正数数组 ！！
// 使用双指针 解决本题: left指针代 表的是每一个以left位置开头的子数组：
//1. 当left ~ right 之间的子数组和 >=s 时，说明left ~ right后面的每一个位置的子数组和都 >=s , 所以此时可以停止考虑以left开始的所有子数组的情况了, 此时重新计算left++同时更新计算sum;
//2. 否则（else left ~ right之间的子数组和 <s ）, 则right++, 并判断right是否数组下标越界, 如不越界,则重新计算sum。

// 写法一 (完全采用题 ” 76. Minimum Window Substring ” 的写法) !!	
// 模板 !
class Solution {
	public int minSubArrayLen(int s, int[] arr) {
		if (arr == null || arr.length == 0 || s <= 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		while (right < arr.length) {
			sum += arr[right];
			while (sum >= s) {                    // 注意, 这里是while !
				len = Math.min(len, right - left + 1);
				sum -= arr[left];
				left++;
			}
			right++;
		}
		return len == Integer.MAX_VALUE ? 0 : len;
		/** 或者如下写法 (和题 76 完全一样的写法 !)
          if (!flag) 
            return 0;
        	else 
            return len;
		*/
	}
}

// 写法二 参考 “zuochengyun 未排序正数数组中累加和为给定值的最长子数组长度” .
class Solution {
	public int minSubArrayLen(int s, int[] arr) {
		if (arr == null || arr.length == 0 || s <= 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int len = Integer.MAX_VALUE;
		while (right < arr.length) {
			if (sum >= s) {
				len = Math.min(len, right - left + 1);
				sum -= arr[left];           //先减后left++
				left++;
			} else {
				right++;                     
				if (right == arr.length) {
					break;
				}
				sum += arr[right];         //先right++后减（不能随时计算sum，先预支。。）
			}
		}
		return len == Integer.MAX_VALUE ? 0 : len;    //如果没有找到满足要求的子数组，则返回 0
	}
}
