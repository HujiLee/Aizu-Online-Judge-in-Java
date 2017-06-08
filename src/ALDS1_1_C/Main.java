package ALDS1_1_C;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

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

    public static void main(String[] args) {
        int lengthOfList = scanner.nextInt();
        int countPrimeNumber = 0;
        while (lengthOfList > 0) {
            if (Helper.isPrime(scanner.nextInt())) {
                countPrimeNumber++;
            }
            lengthOfList--;
        }
        System.out.println(countPrimeNumber);

    }
}
/*
ステータス
Judge: 3/4	JAVA	CPU: 20.00 sec	Memory: 127728 KB	Length: 1975 B	2017-06-09 01:06	2017-06-09 01:06
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.07 sec	124012 KB	43 B	2 B	test_case_1
Case #2:	: Accepted	00.08 sec	123772 KB	298 B	3 B	test_case_2
Case #3:	: Accepted	00.73 sec	127728 KB	5886 B	3 B	test_case_3
Case #4:	: Time Limit Exceeded	20.00 sec	124120 KB	88820 B	4 B	test_case_4
 */