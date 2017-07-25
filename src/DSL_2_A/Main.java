package DSL_2_A;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/**
 * Created by HU on 2017/7/8.
 */
class Solver{
    private ArrayList<Integer> list;
    Solver(final int size){
        list = new ArrayList<Integer>(){{
           for(int i = 0;i<size;i++){
               this.add(Integer.MAX_VALUE);
           }
        }};
    }
    void update(int index,int value){
        list.set(index,value);
    }
    int find(int idx1,int idx2){
        assert (idx1<=idx2);
        int min = Integer.MAX_VALUE;
        for(int i = idx1;i<=idx2;i++){
            int val  = list.get(i);
            if(val<min){
                min = val;
            }

        }
        return min;
    }
}
/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_A
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }
    public static void main(String[] args) throws IOException {
        int n = getInt();
        int q = getInt();
        Solver solver = new Solver(n);
        for(int i = 1;i<=q;i++){
            switch (getInt()){
                case 0:solver.update(getInt(),getInt());
                    break;
                case 1:
                    System.out.println(solver.find(getInt(),getInt()));
                    break;
            }
        }

    }
}
//accept
/*
Status
Judge: 20/20	JAVA	CPU: 03.95 sec	Memory: 67284 KB	Length: 1540 B	2017-07-08 16:21	2017-07-08 16:21
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	24052 KB	34 B	15 B	00_small_00.in
Case #2:	: Accepted	00.03 sec	24136 KB	95 B	60 B	00_small_01.in
Case #3:	: Accepted	00.04 sec	24236 KB	209 B	159 B	00_small_02.in
Case #4:	: Accepted	00.04 sec	24320 KB	537 B	340 B	00_small_03.in
Case #5:	: Accepted	00.03 sec	24496 KB	330 B	89 B	01_rand_00.in
Case #6:	: Accepted	00.03 sec	24080 KB	337 B	67 B	01_rand_01.in
Case #7:	: Accepted	00.03 sec	24216 KB	355 B	60 B	01_rand_02.in
Case #8:	: Accepted	00.03 sec	24132 KB	748 B	141 B	01_rand_03.in
Case #9:	: Accepted	00.03 sec	24304 KB	665 B	106 B	02_biased_00.in
Case #10:	: Accepted	00.03 sec	24348 KB	664 B	176 B	02_biased_01.in
Case #11:	: Accepted	00.04 sec	24428 KB	678 B	107 B	02_biased_02.in
Case #12:	: Accepted	02.41 sec	64004 KB	1177793 B	100000 B	02_biased_03.in
Case #13:	: Accepted	00.08 sec	29448 KB	9145 B	2488 B	03_rand_00.in
Case #14:	: Accepted	00.23 sec	39208 KB	106903 B	18020 B	03_rand_01.in
Case #15:	: Accepted	00.28 sec	38872 KB	106917 B	18510 B	03_rand_02.in
Case #16:	: Accepted	00.29 sec	36876 KB	122323 B	17182 B	03_rand_03.in
Case #17:	: Accepted	03.95 sec	67284 KB	1368658 B	120229 B	03_rand_04.in
Case #18:	: Accepted	03.73 sec	64108 KB	1368841 B	123426 B	03_rand_05.in
Case #19:	: Accepted	02.62 sec	64664 KB	1327903 B	108307 B	04_maximum_00.in
Case #20:	: Accepted	02.66 sec	65016 KB	1427339 B	183023 B	04_maximum_01.in
 */