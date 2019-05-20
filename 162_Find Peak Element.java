//注：该题目的base case一共有四种情况，全部都要写出去！！
class Solution {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {             //1. 数组为空
			return -1;
		}
		if (nums.length == 1) {                             //2. 数组中只有一个元素，直接返回该元素下标
			return 0;
		}

		if (nums[0] > nums[1]) {                            //3. 开头第一个元素比开头第二个元素大，直接返回第一个下标0
			return 0;
		}

		if (nums[nums.length - 1] > nums[nums.length - 2]) { //4. 同理，  结尾最后一个元素比倒数第二个大，直接返回最后一个下标nums.length - 1.
			return nums.length - 1;
		}

		int left = 1;                           //注意，left和right的下标值绝对不能从0和nums.length - 1开始，否则在while循环中会产生数组下标越界！！！
		int right = nums.length - 2;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] < nums[mid - 1]) {
				right = mid - 1;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;                         //否则，返回mid。
			}
		}
		return left;
	}
}

//简便做法 （因为题目有条件 ：（You may imagine that nums[-1] = nums[n] = -∞.）
class Solution {
	public int findPeakElement(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return 0;
		}
		int i = 0;
		for (; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}
		return i;
	}
}

/*
*****和该题目类似：
//在数组中找到一个局部最小的位置
class Solution {
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}
}
*/

