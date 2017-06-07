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
 * 最长公共子序列问题
 */
class Solver {
    final String seq1, seq2;
    final char[] cseq1,cseq2;
    private int[][] lcs;

    /**
     *
     * @param seq1 用于取子序列的第1个字符串
     * @param seq2 用于取子序列的第2个字符串
     */
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

    /**
     * seq1的前idxForSeq1个字符和seq2的前idxForSeq2个字符,构成了子问题
     * @param idxForSeq1
     * @param idxForSeq2
     * @return 子问题下的最长公共子序列的大小
     */
    private int lcs(int idxForSeq1, int idxForSeq2) {
        if(lcs[idxForSeq1][idxForSeq2]<0){

            if (idxForSeq1 == 0 || idxForSeq2 == 0) {
                //为0表示子问题的其中一个输入是长度为0的字符串,那么最长公共子序列的大小为0
                lcs[idxForSeq1][idxForSeq2]=0;
            }else{
                if(cseq1[idxForSeq1-1]==cseq2[idxForSeq2-1]){
                    //这个条件表示,两个输入串的末尾字符是相同的,那么末尾这个字符肯定存在两者的最长公共子序列的最末尾
                    lcs[idxForSeq1][idxForSeq2]=lcs(idxForSeq1-1, idxForSeq2-1)+1;
                }else{
                    //两个输入串的末位字符不相同,那么两者的最长公共子序列要么是..要么是...
                    /*
                    比如,X="abccdb",Y="abcba",两者的末位字符不相同
                    X(-1)="abccd",Y="abcba",这两个人的最长公共子序列为"abc"
                    X="abccdb",Y(-1)="abcb",这两个人的最长公共子序列为"abcb"
                    那么,X与Y的最长公共子序列就是"abc"和"abcb"中更长的那个
                     */
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