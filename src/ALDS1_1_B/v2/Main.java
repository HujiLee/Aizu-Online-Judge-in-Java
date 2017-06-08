package ALDS1_1_B.v2;

        import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int gcd(int x,int y){
        while (x!=y&&y!=0){
            int nextX = y;
            int nextY = x%y;
            x  = nextX;
            y = nextY;
        }
        return x;
    }
    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a,b));
    }
}
/*
ステータス
Judge: 10/10	JAVA	CPU: 00.05 sec	Memory: 26136 KB	Length: 515 B	2017-06-09 00:13	2017-06-09 00:13
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.05 sec	25684 KB	6 B	2 B	test_case_1
Case #2:	: Accepted	00.05 sec	25584 KB	9 B	3 B	test_case_2
Case #3:	: Accepted	00.05 sec	25952 KB	6 B	3 B	test_case_3
Case #4:	: Accepted	00.05 sec	26108 KB	8 B	2 B	test_case_4
Case #5:	: Accepted	00.05 sec	26120 KB	12 B	3 B	test_case_5
Case #6:	: Accepted	00.05 sec	25648 KB	11 B	3 B	test_case_6
Case #7:	: Accepted	00.05 sec	26136 KB	14 B	3 B	test_case_7
Case #8:	: Accepted	00.05 sec	25968 KB	18 B	5 B	test_case_8
Case #9:	: Accepted	00.05 sec	25828 KB	21 B	9 B	test_case_9
Case #10:	: Accepted	00.05 sec	25780 KB	20 B	2 B	test_case_10
 */