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
         * @anchor http://d.hatena.ne.jp/pashango_p/20090704/1246692091
         * @param q
         * @return
         */
        static boolean isPrime(int q){
            q= Math.abs(q);
            if(q==2)return true;
            if(q<2||(q&1)==0)return false;
            BigInteger bigInteger = new BigInteger("2");
            bigInteger = bigInteger.pow(q-1);
            bigInteger = bigInteger.mod(BigInteger.valueOf(q));
            return bigInteger.intValue()==1;
        }
    }

    public static void main(String[] args) {
        int lengthOfList = scanner.nextInt();
        int countPrimeNumber = 0;
        while (lengthOfList > 0) {
            if (FermatTheory.isPrime(scanner.nextInt())) {
                countPrimeNumber++;
            }
            lengthOfList--;
        }
        System.out.println(countPrimeNumber);

    }
}
/*
Status
Judge: 3/4	JAVA	CPU: 20.00 sec	Memory: 778460 KB	Length: 2688 B	2017-06-09 11:46	2017-06-09 11:46
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.06 sec	25964 KB	43 B	2 B	test_case_1
Case #2:	: Accepted	00.06 sec	26208 KB	298 B	3 B	test_case_2
Case #3:	: Accepted	00.14 sec	38684 KB	5886 B	3 B	test_case_3
Case #4:	: Memory Limit Exceeded	20.00 sec	778460 KB	88820 B	4 B	test_case_4

http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2360995#2
 */