class Solution {
	public int findMin(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) { // 注：也可以写成while(low<=high)
			int mid = low + (high - low) / 2;
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else if (arr[mid] == arr[high]) {
				high = high - 1;
			} else {
				high = mid;
			}
		}
	 	return arr[low];
	}
}
