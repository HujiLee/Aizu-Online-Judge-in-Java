package ALDS1_9_A;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.TreeMap;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_A
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    static final String KEY = "key";
    static final String PARENT = "parent";
    static final String LEFT = "left key";
    static final String RIGHT = "right key";

    static String nodeAt(final int index, final int[] compBinTree) {
        assert (index >= 1 && index < compBinTree.length);

        TreeMap<String, Integer> map = new TreeMap<String, Integer>() {{
            this.put(KEY, compBinTree[index]);
            this.put(PARENT, null);
            this.put(LEFT, null);
            this.put(RIGHT, null);
        }};
        if(index>1){
            map.put(PARENT,compBinTree[index/2]);
        }
        int lefti = 2*index;
        if(lefti<compBinTree.length){
            map.put(LEFT,compBinTree[lefti]);
        }
        int righti = 2*index+1;
        if(righti<compBinTree.length){
            map.put(RIGHT,compBinTree[righti]);
        }
        String result = String.format("node %s: key = %s, ",index,map.get(KEY));
        if(map.get(PARENT)!=null){
            result = String.format("%sparent key = %s, ",result,map.get(PARENT));
        }
        if(map.get(LEFT)!=null){
            result = String.format("%sleft key = %s, ",result,map.get(LEFT));
        }
        if(map.get(RIGHT)!=null){
            result = String.format("%sright key = %s, ",result,map.get(RIGHT));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        final int H = getInt();
        int[] asCompleteBinTree = new int[H + 1];// index=0的位置不去使用它
        for (int i = 1; i <= H; i++) {
            asCompleteBinTree[i] = getInt();
        }
        for(int i = 1;i<=H;i++){
            System.out.println(nodeAt(i,asCompleteBinTree));
        }
    }
}
/*
#2511070 Solution for ALDS1_9_A: Complete Binary Tree by Hujimiya
http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2511070#2
Status
Judge: 4/4	JAVA	CPU: 00.10 sec	Memory: 30244 KB	Length: 2282 B	2017-08-27 00:10	2017-08-27 00:10
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	24464 KB	15 B	263 B	test_case_1
Case #2:	: Accepted	00.04 sec	24736 KB	45 B	818 B	test_case_2
Case #3:	: Accepted	00.05 sec	24988 KB	87 B	1562 B	test_case_3
Case #4:	: Accepted	00.10 sec	30244 KB	729 B	13056 B	test_case_4
 */