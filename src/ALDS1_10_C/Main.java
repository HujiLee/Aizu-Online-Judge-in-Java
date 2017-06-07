package ALDS1_10_C;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_10_C
 */
class Solver {
    final String seq1, seq2;
    final char[] cseq1,cseq2;
    private int[][] lcs;

    Solver(String seq1, String seq2) {
        this.seq1 = seq1;
        this.seq2 = seq2;
        cseq1 = seq1.toCharArray();
        cseq2 = seq2.toCharArray();
        lcs = new int[seq1.length() + 1][seq2.length() + 1];
        for (int i = 1; i <= cseq1.length; i++) {
            for (int j = 1; j <= cseq2.length; j++) {
                lcs[i][j] = -1;
            }
        }
    }

    private int lcs(int idxForSeq1, int idxForSeq2) {
        if(lcs[idxForSeq1][idxForSeq2]<0){
            if (idxForSeq1 == 0 || idxForSeq2 == 0) {
                lcs[idxForSeq1][idxForSeq2]=0;
            }else{
                if(cseq1[idxForSeq1-1]==cseq2[idxForSeq2-1]){
                    lcs[idxForSeq1][idxForSeq2]=lcs(idxForSeq1-1, idxForSeq2-1)+1;
                }else{
                    lcs[idxForSeq1][idxForSeq2] = Math.max(
                      lcs(idxForSeq1-1, idxForSeq2),lcs(idxForSeq1, idxForSeq2-1)
                    );
                }
            }
        }
        return lcs[idxForSeq1][idxForSeq2];

    }

    public int calcLcsLength() {
        return lcs(cseq1.length,cseq2.length);
    }

}


public class Main {
    private static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static String getString() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.sval;
    }

    public static void main(String[] args) throws IOException {
        streamTokenizer.nextToken();
        int count = (int) streamTokenizer.nval;
        while (count > 0) {
            count--;
            Solver solver = new Solver(getString(), getString());
            System.out.println(solver.calcLcsLength());
        }

    }
}
//: Accepted	5/5	JAVA	00:26 s	62884 KB	2116 B	2017-06-07 19:20
/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2358551#2
 * 五个输入用例的各自耗时和内存占用
 */