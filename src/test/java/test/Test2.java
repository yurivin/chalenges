package test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.pow;

public class Test2 {

    @Test
    public void test1() {
        int[] A = new int[3];
        A[0] = 1;    A[1] = 4;    A[2] = 5;
        System.out.println(pow2(A[0]) + pow2(A[1]) + pow2(A[2]));

        System.out.println(solution(A));
    }

    /** Not the best right solution. Bad about speed and not all edge cases runs good */
    public int solution(int[] A) {
        double K = 0;
        for(int i=0; i < A.length; i++) {
            K = K + pow2(A[i]);
        }
        double tripleK = K*3;
        BigInteger tKBinary = new BigInteger(Integer.toString(new BigDecimal(Double.toString(tripleK)).intValue()));
        String binary3K = tKBinary.toString(2);
        String[] parts = binary3K.split("1");
        return parts.length - 1;
    }

    private double pow2(int value) {
        return pow(2, value);
    }
}
