package ALDS1_1_A.use_array_list;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_A&lang=jp
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    static void printArray(List<Integer> arr) {
        byte flag = 0;
        for (Integer i : arr) {
            if (flag != 0) {
                System.out.print(" ");
            }
            System.out.print(i);
            flag++;
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        int arrLength = getInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arrLength; i++) {
            list.add(getInt());
        }
        for (int i = 0; i < arrLength; i++) {
            int temp = list.get(i);
            int specialIndex = -1;
            for (int j = 0; j < i; j++) {
                if (list.get(j) > temp) {
                    specialIndex = j;
                    break;
                }
            }
            if (specialIndex >= 0) {
                for (int k = i - 1; k >= specialIndex; k--) {
                    list.set(k + 1, list.get(k));
                }
                list.set(specialIndex, temp);
            }
            printArray(list);

        }


        System.out.print("");
    }
}
//: Accepted	5/5	JAVA	00:14 s	32116 KB	1682 B	2017-06-08 22:30
/*
ステータス
Judge: 5/5	JAVA	CPU: 00.14 sec	Memory: 32116 KB	Length: 1682 B	2017-06-08 23:30	2017-06-08 23:30
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.04 sec	24152 KB	14 B	72 B	in1.in
Case #2:	: Accepted	00.03 sec	24120 KB	24 B	210 B	in2.in
Case #3:	: Accepted	00.03 sec	24072 KB	6 B	4 B	in3.in
Case #4:	: Accepted	00.05 sec	24260 KB	54 B	1020 B	in4.in
Case #5:	: Accepted	00.14 sec	32116 KB	397 B	39300 B	in5.in

http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2360716#2
 */