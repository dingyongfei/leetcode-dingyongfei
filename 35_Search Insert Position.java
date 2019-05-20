class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        int s = 0;
        int e = nums.length - 1;
        while(s<=e) {           //注意，本题是严格的">="，这样才能保证在s==e时，s指针能继续移动到最后一个正确的位置上！
            int mid = (e-s)/2 + s;
            if(nums[mid]>target) {
                e = mid -1;
            } else if(nums[mid]<target) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return s;      //结果直接返回s。
    }
}
