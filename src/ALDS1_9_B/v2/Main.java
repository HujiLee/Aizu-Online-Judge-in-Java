package ALDS1_9_B.v2;

/**
 * Created by Hujimiya on 2017/8/27.
 * ( ﾟдﾟ )笑顔
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_B
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    static void maxHeapify(int[] heap,int index){
        int left,right,largest = index;
        left = 2*index;
        right = index*2+1;

        if(left<=HEAP_SIZE&&heap[left]>heap[index]){
            largest = left;
        }
        if(right<=HEAP_SIZE&&heap[right]>heap[largest]){
            largest = right;
        }
        if(largest!=index){
            // swap index <-> largest
            heap[index] = heap[index]+heap[largest];
            heap[largest] = heap[index]-heap[largest];
            heap[index] = heap[index]-heap[largest];
            maxHeapify(heap,largest);
        }
    }
    static int HEAP_SIZE;
    public static void main(String[] args) throws IOException {
        HEAP_SIZE = getInt();
        int[] heap = new int[HEAP_SIZE+1];
        for(int i =1;i<=HEAP_SIZE;i++){
            heap[i] = getInt();
        }
        for(int i = HEAP_SIZE/2;i>=1;i--){
            maxHeapify(heap,i);
        }
        for(int i = 1;i<=HEAP_SIZE;i++){
            System.out.print(" "+heap[i]);
        }
        System.out.println();
    }
}
/*
Status
Judge: 6/6	JAVA	CPU: 00.99 sec	Memory: 100172 KB	Length: 1589 B	2017-08-27 18:05	2017-08-27 18:05
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	24148 KB	8 B	7 B	1.in
Case #2:	: Accepted	00.03 sec	24144 KB	30 B	28 B	2.in
Case #3:	: Accepted	00.03 sec	24128 KB	62 B	60 B	3.in
Case #4:	: Accepted	00.03 sec	24220 KB	296 B	293 B	4.in
Case #5:	: Accepted	00.05 sec	27064 KB	3898 B	3894 B	5.in
Case #6:	: Accepted	00.99 sec	100172 KB	3388902 B	3388896 B	6.in
 */