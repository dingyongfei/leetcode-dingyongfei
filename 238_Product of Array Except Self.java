// [1, len - 1] 和 [len - 2, 0].
class Solution {
    public int[] productExceptSelf(int[] A) {
        if (A == null) {
            return new int[] { -1 };
        }
        int len = A.length;
        int[] B = new int[len];
        
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int j = len - 2; j >= 0; j--) {
            tmp *= A[j + 1];
            B[j] = B[j] * tmp; 
        }
        return B;
    }
}
