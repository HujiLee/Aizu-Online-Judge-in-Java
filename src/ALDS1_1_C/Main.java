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
    static class Helper{
        static boolean[] shouldBeDelete = new boolean[100000000+1];
        static int lastIndex = 2;
        static boolean isPrime(int number){
            if(number<2){
                return false;
            }
            if(number>lastIndex){
                deleteUtil(number);

            }
            return !shouldBeDelete[number];
        }
        static void deleteUtil(int index){
            assert (index>lastIndex);
            for(int i =2;i<=lastIndex;i++){
                if(!shouldBeDelete[i]){
                    for(int k = lastIndex+1;k<=index;k++){
                        if(!shouldBeDelete[k]){
                            if(k%i==0){
                                shouldBeDelete[k]=true;
                            }
                        }

                    }
                }
            }
            lastIndex =index;

        }
    }

    public static void main(String[] args) {
        int lengthOfList = scanner.nextInt();
        int countPrimeNumber = 0;
        while (lengthOfList>0){
            if(Helper.isPrime(scanner.nextInt())){
                countPrimeNumber++;
            }
            lengthOfList--;
        }
        System.out.println(countPrimeNumber);

    }
}
/*
ステータス
Judge: 2/4	JAVA	CPU: 01.50 sec	Memory: 128096 KB	Length: 1501 B	2017-06-09 00:41	2017-06-09 00:41
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.07 sec	123996 KB	43 B	2 B	test_case_1
Case #2:	: Accepted	00.08 sec	124096 KB	298 B	3 B	test_case_2
Case #3:	: Wrong Answer	01.50 sec	128096 KB	5886 B	3 B	test_case_3
Case #4:	-	-	-	88820 B	4 B	test_case_4
 */