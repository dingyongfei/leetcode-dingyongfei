//Catalan数：
/*假设n个无差别的节点构成不同的结构数为f(n)
f(0) = 1, f(1) = 1, f(2) = 2, f(3) = 5...
f(n) = f(0)*f(n-1) + f(1)*f(n-2) + f(3)*f(n-4) +...+... +f(n-1)*f(0)
     =  1/(n+1) * Cn 2n        ------>    卡特兰数重要公式2*/

class Solution {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        /* int num = 0;
         for (int i = 1; i <= n; i++) {
             num = 0;
             for (int j = 1;j <= i;j++) {
                 num += dp[j-1]*dp[i-j];
             }
             dp[i] = num;
         }
         return num;*/
        for (int i = 1; i <= n; i++) {
        	//dp[i] = 0;             ---->     每一层这里的dp[i]都相当于0
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
