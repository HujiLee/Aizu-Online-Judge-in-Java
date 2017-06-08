package ALDS1_1_A.use_normal_int_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    static void printArray(int[] arr){
        byte flag = 0;
        for (int i : arr) {
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
        int[] array = new int[arrLength];
        for(int i =0;i<arrLength;i++){
            array[i] = getInt();
        }
        for(int i =0;i<arrLength;i++){
            int temp = array[i];
            int indiceToStartMoving = -1;
            for(int j=0;j<i;j++){
                if(array[j]>temp){
                    indiceToStartMoving = j;
                    break;
                }
            }
            if(indiceToStartMoving>=0){
                for(int k = i-1;k>=indiceToStartMoving;k--){
                    array[k+1] = array[k];
                }
                array[indiceToStartMoving] = temp;
            }
            printArray(array);

        }


    }
}
/*
Run#	提出者	問題	結果	%	言語	時間	メモリ	コード長	提出日時
2360734	Hujimiya	ALDS1_1_A: Insertion Sort	: Accepted	5/5	JAVA	00:13 s	29564 KB	1514 B	2017-06-08 22:42
 */
/*
ステータス
Judge: 5/5	JAVA	CPU: 00.13 sec	Memory: 29564 KB	Length: 1514 B	2017-06-08 23:42	2017-06-08 23:42
テストケースの判定結果
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	23844 KB	14 B	72 B	in1.in
Case #2:	: Accepted	00.03 sec	24124 KB	24 B	210 B	in2.in
Case #3:	: Accepted	00.03 sec	24068 KB	6 B	4 B	in3.in
Case #4:	: Accepted	00.04 sec	24272 KB	54 B	1020 B	in4.in
Case #5:	: Accepted	00.13 sec	29564 KB	397 B	39300 B	in5.in
 */