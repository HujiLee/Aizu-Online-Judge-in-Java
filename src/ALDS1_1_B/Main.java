package ALDS1_1_B;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

import java.util.Scanner;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_B
 */
public class Main {
    static  Scanner scanner = new Scanner(System.in);
    static int gcd(int x,int y){
       if(x==y){
           return x;
       }
       if(y==0){
           return x;
       }


        return gcd(y,x%y);
    }
    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a,b));

    }
}
/*
ステータス
Judge: 10/10	JAVA	CPU: 00.06 sec	Memory: 26228 KB	Length: 568 B	2017-06-09 00:07	2017-06-09 00:07
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.05 sec	25968 KB	6 B	2 B	test_case_1
Case #2:	: Accepted	00.05 sec	26092 KB	9 B	3 B	test_case_2
Case #3:	: Accepted	00.06 sec	25924 KB	6 B	3 B	test_case_3
Case #4:	: Accepted	00.05 sec	25972 KB	8 B	2 B	test_case_4
Case #5:	: Accepted	00.05 sec	26004 KB	12 B	3 B	test_case_5
Case #6:	: Accepted	00.05 sec	26228 KB	11 B	3 B	test_case_6
Case #7:	: Accepted	00.05 sec	25936 KB	14 B	3 B	test_case_7
Case #8:	: Accepted	00.05 sec	26036 KB	18 B	5 B	test_case_8
Case #9:	: Accepted	00.05 sec	25940 KB	21 B	9 B	test_case_9
Case #10:	: Accepted	00.05 sec	26000 KB	20 B	2 B	test_case_10
 */