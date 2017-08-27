package ALDS1_9_C;
/**
 * Created by Hujimiya on 2017/8/27.
 * ( ﾟдﾟ )笑顔
 */

import java.util.Scanner;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_C
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static class Heap {
        static int[] heap = new int[2000000 + 1];
        static int size = 0;

        static void insert(int num) {
            heap[size + 1] = num;
            size++;
            heapIncreaseKey(size);
        }

        static void extract() {
            System.out.println(heap[1]);
            heap[1] = heap[size];
            size--;
            maxHeapify(1);
        }

        private static void maxHeapify(int index) {
            final int left = 2 * index, right = 2 * index + 1;
            int largest = index;
            if(left<=size&&heap[left]>heap[largest]){
                largest = left;
            }
            if(right<=size&&heap[right]>heap[largest]){
                largest = right;
            }
            if(largest!=index){
                heap[index] = heap[index]+heap[largest];
                heap[largest] = heap[index]-heap[largest];
                heap[index] = heap[index]-heap[largest];
                maxHeapify(largest);
            }
        }

        private static void heapIncreaseKey(int from) {
            while (from > 1 && heap[from / 2] < heap[from]) {
                int parent = from / 2;
                heap[parent] = heap[parent] + heap[from];
                heap[from] = heap[parent] - heap[from];
                heap[parent] = heap[parent] - heap[from];
                from = parent;
            }
        }
    }

    public static void main(String[] args) {
        String cmd;
        while (scanner.hasNextLine()) {
            cmd = scanner.nextLine();
            if (cmd.indexOf("insert") == 0) {
                Heap.insert(Integer.parseInt(cmd.split(" ")[1]));
            } else if (cmd.indexOf("extract") == 0) {
                Heap.extract();
            }
        }

    }
}
/*
first try:
Status
Judge: 3/4	JAVA	CPU: 02.98 sec	Memory: 710072 KB	Length: 2059 B	2017-08-27 19:09	2017-08-27 19:09
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.05 sec	33852 KB	151 B	18 B	2.in
Case #2:	: Accepted	00.05 sec	33860 KB	237 B	45 B	3.in
Case #3:	: Accepted	00.12 sec	42412 KB	24763 B	3570 B	4.in
Case #4:	: Memory Limit Exceeded	02.98 sec	710072 KB	21832058 B	2501775 B	5.in
 */