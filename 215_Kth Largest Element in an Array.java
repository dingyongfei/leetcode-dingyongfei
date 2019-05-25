class Solution {
	int res = 0;

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int pos = nums.length - k;
		quickSort(nums, 0, nums.length - 1, pos);
		return res;
	}

	public void quickSort(int[] arr, int l, int r, int pos) {
		if (l <= r) {                              // 特别注意，这里一定要写成l <= r （一般性的quickSort是 l < r 即可）!!! 否则当所找的值所在的范围只有一个数时 ,如果写成 l < r 的话, 当l = r 时，要找的值会越过边界; 写成l <= r 就会最后寻找一次，最终找到答案 ！
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			if (pos >= p[0] && pos <= p[1]) {
				res = arr[p[0]];
			} else {
				if (pos < p[0]) {
					quickSort(arr, l, p[0] - 1, pos);
				} else if (pos > p[1]) {
					quickSort(arr, p[1] + 1, r, pos);
				}
			}
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

/** 
//Quick sort.
class QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);   // 注意, Math.random()是double类型,一定要转换成int类型 !
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {   // 永远和轴点的值作比较.
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);         // 每次partition结束后都要交换一下.
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
*/
