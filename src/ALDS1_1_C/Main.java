package ALDS1_1_C;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_C
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static class Helper {
        static boolean[] shouldBeDelete = new boolean[100000000 + 1];
        static int lastIndex = 2;

        static boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            if (number > lastIndex) {
                deleteUtil(number);

            }
            return !shouldBeDelete[number];
        }

        static void deleteUtil(int index) {
            assert (index > lastIndex);
            for (int k = lastIndex + 1; k <= index; k++) {
                for (int i = 2; i <= lastIndex; i++) {
                    if (!shouldBeDelete[i]) {
                        if (k % i == 0) {
                            shouldBeDelete[k] = true;
                            break;
                        }
                    }
                }
                lastIndex++;
            }


        }
    }

    static class FermatTheory {
        /**
         * Pythonを使って高速素数判定をしてみる
         *
         * @param q
         * @return
         * @anchor http://d.hatena.ne.jp/pashango_p/20090704/1246692091
         */
        static boolean isPrime(int q) {
            q = Math.abs(q);
            if (q == 2) return true;
            if (q < 2 || (q & 1) == 0) return false;
            BigInteger bigInteger = new BigInteger("2");
            bigInteger = bigInteger.pow(q - 1);
            bigInteger = bigInteger.mod(BigInteger.valueOf(q));
            return bigInteger.intValue() == 1;
        }
    }

    static class MC {

        static private class Data<T> {
            T val;
        }

        static void power(long a, long p, long n, Data<Long> result, Data<Boolean> composite) {
            Data<Long> x = new Data<>();
            if (p == 0) result.val = 1L;
            else {
                power(a, p / 2, n, x, composite);
                result.val = (x.val * x.val) % n;
                if ((result.val == 1L) && (x.val != 1L) && (x.val != n - 1)) {
                    composite.val = true;
                }
                if (p % 2 == 1) {
                    result.val = (result.val * a) % n;
                }
            }
        }

        /**
         * 该算法见于王晓东编著「计算机算法设计与分析(第3版)」的第7章 7.5.3素数测试
         * @param n 待检测是否为素数的n
         * @param k 重复检测次数,错误的概率不超过(1/4)^k,k越大理论上越准确
         * @return {boolean} n是否为素数
         */
        static boolean PrimeMC(long n, long k) {
            long a;
            Data<Long> result = new Data<>();
            Data<Boolean> composite = new Data<Boolean>() {{
                val = false;
            }};
            for (int i = 1; i <= k; i++) {
                a = (long) (Math.random() * (n - 3) + 1);
                power(2, n - 1, n, result, composite);
                if (composite.val || (result.val != 1)) {
                    return false;
                }
            }
            return true;

        }

        static boolean isPrime(int n) {
            if(n==2)return true;
            if(n<2)return false;
            if((n&1)==0)return false;
            return PrimeMC(n, 50);
        }
    }

    public static void main(String[] args) {
        int lengthOfList = scanner.nextInt();
        int countPrimeNumber = 0;
        while (lengthOfList > 0) {
            if (MC.isPrime(scanner.nextInt())) {
                countPrimeNumber++;
            }
            lengthOfList--;
        }
        System.out.println(countPrimeNumber);

    }
}
/*
Status
Judge: 5/5	JAVA	CPU: 00.26 sec	Memory: 62884 KB	Length: 2116 B	2017-06-07 20:20	2017-06-07 20:20
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	24092 KB	225 B	26 B	1.in
Case #2:	: Accepted	00.03 sec	24156 KB	1464 B	246 B	2.in
Case #3:	: Accepted	00.04 sec	24160 KB	1464 B	246 B	3.in
Case #4:	: Accepted	00.26 sec	62884 KB	40043 B	80 B	4.in
Case #5:	: Accepted	00.05 sec	36948 KB	5984 B	13 B	5.in

http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2358551#2
 */