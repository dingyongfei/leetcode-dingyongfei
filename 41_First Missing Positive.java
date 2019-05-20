class Solution {
	public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) {
            return 1;
        }
        int len = nums.length;
        int i = 0;
        for(;i<len;i++) {
            while(nums[i]>0&&nums[i]<(或<=)len&&nums[i]!=nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for(i=0;i<len;i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return len+1;
        
    }

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
