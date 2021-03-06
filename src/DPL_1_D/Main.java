package DPL_1_D;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_D&lang=jp
 * 最长递增子序列
 */
class Solver {
    final long[] raw_sequence;
    final int[] LIS_table;

    Solver(long[] raw_sequence) {
        this.raw_sequence = raw_sequence;
        LIS_table = new int[raw_sequence.length];
    }

    private void initTable() {
        for (int i = 0; i < raw_sequence.length; i++) {
            LIS_table[i] = 1;
            for (int j = 0; j < i; j++) {
                if (raw_sequence[j] < raw_sequence[i] && LIS_table[j] + 1 > LIS_table[i]) {
                    LIS_table[i] = LIS_table[j]+1;
                }
            }
        }
    }

    int getResult() {
        initTable();
        int max = -1;
        for (int i = 0; i < LIS_table.length; i++) {
            if (LIS_table[i] > max) {
                max = LIS_table[i];
            }
        }
        return max;

    }
}

public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        int length = getInt();
        long[] seq = new long[length];
        for (int i = 0; i < length; i++) {
            seq[i] = (long) getInt();
        }
        Solver solver = new Solver(seq);
        System.out.println(solver.getResult());

    }
}
/*
超时:
Case #24:	: Time Limit Exceeded	12.77 sec	41684 KB	200007 B	3 B	05_maximum_01.in
 */