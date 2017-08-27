package ALDS1_9_B;



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
            res+=arrAsHeap[i];
            if(i<SIZE){
                res+=" ";
            }
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