// Digital root
// 性质: x + 9与x的数根相同，即一个数加9后它的数根不变。
// 公式法求数根：a的数根b = a % 9, 即 mod(a, 9)，且a ∈ N*
class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;          // 公式法求数根
    }
}

/** 等同于如下:
         /  0             (n == 0)
dr(n) = { 9               (n != 0 && n % 9 == 0)
         \ n % 9          (n % 9 != 0)
equals to 
dr(n) = 1 + (n - 1) % 9
*/
