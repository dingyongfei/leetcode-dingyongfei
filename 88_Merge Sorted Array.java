class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*if(nums1 == null || nums2 == null || m < 0 || n <= 0) {             // 不能写成“m<=0” ([0] 0 [1] 1 --->,正确结果应该为[1], 测试用例不通过) 
            return;
        } */
        m = m - 1;
        n = n - 1;
        int len = nums1.length - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[len--] = nums2[n--];                 //记住，从后往前覆盖！
            } else {
                nums1[len--] = nums1[m--];
            }
        }
        while (m >= 0) {
            nums1[len--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[len--] = nums2[n--];
        }
    }
}
