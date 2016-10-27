# mpsFibonacci

**
 * Solution for fibonacci n-th number, using matrix algorithm - time complexity O(log n).
 *
 * by Marcin Szuppe 2016
 *
 * fib(0) = 0;
 * fib(10 = 1;
 * fib(n) = fib(n-1) + fib(n-2) for n>1;
 *
 * Let X = | 0  1 |
 *         | 1  0 |
 *
 * fib(n) = | 1  1 | * X^(n-2) * | 1 |
 *                               | 1 |
 *
 * We can factorize (n-2) into its binary reprezentation b0b1b2....bk, using this pattern:
 *     a^b = a^(b0*2^0+b1*2^1+ ...+bk*2^k) = a^(b0*2^0)*a^(b1*2^1)*...*a^(bk*2^k)
 *
 * Time complexity is O(k) = O(log n), becouse k = [log(n)]+1
 *
