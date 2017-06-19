package p0006;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

import java.util.Scanner;

/**Reverse Sequence
 *
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0006
 */
public class
Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        for(int i = chars.length-1;i>=0;i--){
            System.out.print(chars[i]);
        }
        System.out.println();

    }
}
/*
ステータス
Judge: 1/1	JAVA	CPU: 00.05 sec	Memory: 25952 KB	Length: 521 B	2017-06-20 08:54	2017-06-20 08:54
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.05 sec	25952 KB
 */