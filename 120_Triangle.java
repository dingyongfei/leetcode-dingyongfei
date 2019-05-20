//从下至上，从左至右地dp.
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int row = t.size();
        int col = t.get(t.size()-1).size();
        int[][] dp = new int[row][col];
        for(int j=0;j<col;j++) {
            dp[row-1][j] = t.get(row-1).get(j);
        }
        for(int i=row-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {             //这里是"j<=i"，没毛病
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + t.get(i).get(j);
            }
        } 
        return dp[0][0];
    }
}


//方法二，进一步地，用一维数组dp:
//" since the row minpath[k+1] would be useless after minpath[k] is computed, we can simply set minpath as a 1D array, and iteratively update itself"
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int len = t.size();
        int[] dp = new int[len];
        int k = 0;
        for(int a : t.get(len-1)) {
            dp[k++] = a;
        }
        for(int i=len-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + t.get(i).get(j);
            }
        } 
        return dp[0];
    }
}
