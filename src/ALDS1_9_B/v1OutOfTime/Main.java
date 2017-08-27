package ALDS1_9_B.v1OutOfTime;



import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


class MaxHeap {

    private final int SIZE;
    private int[] arrAsHeap;

    public MaxHeap(int size) throws IOException {
        this.SIZE = size;
        this.arrAsHeap = new int[size + 1];// index=0的位置不使用
        for (int i = 1; i <= size; i++) {
            this.arrAsHeap[i] = Main.getInt();
        }
    }

    private void maxHeapify(int index) {
        assert (index >= 1);
        Integer maxChild = null, maxChildIndex = null;
        Integer leftVal = null, rightVal = null;
        if (2 * index <= SIZE) {
            leftVal = arrAsHeap[2 * index];
        }
        if (2 * index + 1 <= SIZE) {
            rightVal = arrAsHeap[2 * index + 1];
        }
        if (leftVal != null && rightVal != null) {
            if (leftVal > rightVal) {
                maxChild = leftVal;
                maxChildIndex = 2 * index;
            } else {
                maxChild = rightVal;
                maxChildIndex = 2 * index + 1;
            }
        } else if (leftVal == null && rightVal != null) {
            maxChild = rightVal;
            maxChildIndex = 2 * index + 1;

        } else if (leftVal != null) {
            maxChild = leftVal;
            maxChildIndex = 2 * index;
        } else {
            // left and right is null
            // just do nothing
        }
        if (maxChild != null) {
            if (maxChild > arrAsHeap[index]) {
                //交换值
                int temp = arrAsHeap[index];
                arrAsHeap[index] = maxChild;
                arrAsHeap[maxChildIndex] = temp;
                // 向下循环该处理
                maxHeapify(maxChildIndex);
            }
        }


    }

    void buildMaxHeap() {
        for (int i = SIZE / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 1;i<=SIZE;i++){
            res += " ";
            res+=arrAsHeap[i];
        }
        return res;
    }
}

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_B
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        int size = getInt();
        MaxHeap heap = new MaxHeap(size);
        heap.buildMaxHeap();
        System.out.println(heap);

    }
}
/*
Status
Judge: 5/6 JAVA CPU: 20.00 sec Memory: 700752 KB Length: 2685 B 2017-08-27 17:25 2017-08-27 17:25
Results for testcases
Case # Verdict CPU Time Memory In Out Case Name
Case #1: : Accepted 00.03 sec 24448 KB 8 B 7 B 1.in
Case #2: : Accepted 00.03 sec 24112 KB 30 B 28 B 2.in
Case #3: : Accepted 00.03 sec 24044 KB 62 B 60 B 3.in
Case #4: : Accepted 00.03 sec 24380 KB 296 B 293 B 4.in
Case #5: : Accepted 00.07 sec 57976 KB 3898 B 3894 B 5.in
Case #6: : Memory Limit Exceeded 20.00 sec 700752 KB 3388902 B 3388896 B 6.in
 */