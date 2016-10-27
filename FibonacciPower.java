import java.math.BigInteger;

/**
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
 * */

public class FibonacciPower {
    public BigInteger fib(int n) {

        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");

        if (n == 0) return zero;
        if ((n == 1) || (n == 2)) return one;

        Matrix22 xN = new Matrix22(zero, one, one, one);
        Matrix22 tmp = new Matrix22(one, zero, zero, one);

        int r = 0;
        n -= 3;

        while (n > 0) {
            r = n%2;
            n /=2 ;
            tmp.multiply(xN,r);
            xN.multiply(xN);
        }
        return tmp.selfSum();
    }
}

class Matrix22 {
    private BigInteger x00;
    private BigInteger x01;
    private BigInteger x10;
    private BigInteger x11;

    Matrix22(BigInteger x00, BigInteger x01, BigInteger x10, BigInteger x11) {
        this.x00 = x00;
        this.x01 = x01;
        this.x10 = x10;
        this.x11 = x11;
    }

    void multiply(Matrix22 m, int a) {

        if (a == 1) {
            BigInteger a00 = (x00.multiply(m.x00)).add(x01.multiply(m.x10));
            BigInteger a01 = (x00.multiply(m.x01)).add(x01.multiply(m.x11));
            BigInteger a10 = (x10.multiply(m.x00)).add(x11.multiply(m.x10));
            BigInteger a11 = (x10.multiply(m.x01)).add(x11.multiply(m.x11));
            x00 = a00;
            x01 = a01;
            x10 = a10;
            x11 = a11;
        }
    }

    void multiply(Matrix22 m) {

        BigInteger a00 = (x00.multiply(m.x00)).add(x01.multiply(m.x10));
        BigInteger a01 = (x00.multiply(m.x01)).add(x01.multiply(m.x11));
        BigInteger a10 = (x10.multiply(m.x00)).add(x11.multiply(m.x10));
        BigInteger a11 = (x10.multiply(m.x01)).add(x11.multiply(m.x11));
        x00 = a00;
        x01 = a01;
        x10 = a10;
        x11 = a11;
    }

   BigInteger selfSum() {
        return ((x00.add(x01))).add((x10.add(x11)));
    }
    @Override
    public String toString() {
        return ""+x00+"\t"+x01+"\n"+x10+"\t"+x11+"\n";
    }
}
