package DSL_1_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
interface DSL_1_A_Solver {
    void unite(int x,int y);
    boolean same(int x,int y);
}
class v1{
   static class Solver implements DSL_1_A_Solver {

        private final int size;
        private HashSet[] sets;

        Solver(int size) {
            this.size  =size;
            sets = new HashSet[size];
        }


        public void unite(int x,int y){
            assert (x<size)&&(y<size);
            if(sets[x]==null){
                final int initValue = x;
                sets[x] = new HashSet<Integer>(){{add(initValue);}};
            }
            if(sets[y]==null){
                final int initValue = y;
                sets[y] = new HashSet<Integer>(){{add(initValue);}};
            }

            int biggerSetIndex;
            if(sets[x].size()>sets[y].size()){
                biggerSetIndex = x;
            }else{
                biggerSetIndex = y;
            }

            unionAt(biggerSetIndex,(x+y)-biggerSetIndex);
        }

        @SuppressWarnings("unchecked")
        private void unionAt(int biggerSetIndex,int smallerSetIndex){
            HashSet set = (sets[biggerSetIndex]);
            for(Object i:sets[smallerSetIndex]){
                boolean added = set.add(i);
            }
            for(Object i:set){
                sets[(Integer)i] = set;
            }
        }

        public boolean same(int x,int y){
            if(sets[x]==null){
                return false;
            }
            if(sets[y]==null){
                return false;
            }
            return sets[x]==sets[y];
        }

    }
}

class v2{
    static class Solver implements DSL_1_A_Solver {
        final int size;
        private int[] father;

        Solver(int size) {
            this.size = size;
            father = new int[size];
            for(int i =0;i<size;i++){
                father[i] = i;
            }
        }
        private int getFather(int x){
            int f = this.father[x];
            while (f!=this.father[f]){
                f = this.father[f];
            }

            return f;
        }

        public void unite(int x, int y){
            int xf = getFather(x);
            int yf = getFather(y);
            if(yf!=xf){
                father[yf]=xf;
            }
        }

        public boolean same(int x,int y){
            int xf = getFather(x);
            int yf = getFather(y);
            return xf==yf;
        }



    }
}
/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_1_A
 */
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = getInt();
        int q = getInt();
        DSL_1_A_Solver solver = new v2.Solver(n);
        int command;

        while (q>0){
            command = getInt();
            if(command==0){
                solver.unite(getInt(),getInt());
            }else {
                System.out.println(solver.same(getInt(),getInt())?1:0);
            }
            q--;
        }

    }
}
/*
Status
Judge: 32/32	JAVA	CPU: 00.73 sec	Memory: 36912 KB	Length: 5894 B	2017-06-20 01:36	2017-06-20 01:36
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	23800 KB	77 B	16 B	00_small_00.in
Case #2:	: Accepted	00.03 sec	24000 KB	113 B	12 B	00_small_01.in
Case #3:	: Accepted	00.03 sec	23980 KB	186 B	28 B	01_rand_00.in
Case #4:	: Accepted	00.03 sec	24124 KB	186 B	24 B	01_rand_01.in
Case #5:	: Accepted	00.03 sec	24048 KB	378 B	44 B	01_rand_02.in
Case #6:	: Accepted	00.03 sec	23956 KB	784 B	92 B	01_rand_03.in
Case #7:	: Accepted	00.05 sec	25216 KB	7646 B	826 B	01_rand_04.in
Case #8:	: Accepted	00.04 sec	25260 KB	4910 B	508 B	01_rand_05.in
Case #9:	: Accepted	00.02 sec	23988 KB	114 B	18 B	02_linear_00.in
Case #10:	: Accepted	00.06 sec	26088 KB	19549 B	1998 B	02_linear_01.in
Case #11:	: Accepted	00.11 sec	31128 KB	115531 B	9998 B	02_linear_02.in
Case #12:	: Accepted	00.18 sec	32232 KB	235541 B	19998 B	02_linear_03.in
Case #13:	: Accepted	00.03 sec	24080 KB	139 B	14 B	03_grid_00.in
Case #14:	: Accepted	00.03 sec	24052 KB	720 B	92 B	03_grid_01.in
Case #15:	: Accepted	00.03 sec	24092 KB	773 B	88 B	03_grid_02.in
Case #16:	: Accepted	00.03 sec	24284 KB	767 B	104 B	03_grid_03.in
Case #17:	: Accepted	00.03 sec	24036 KB	792 B	114 B	03_grid_04.in
Case #18:	: Accepted	00.03 sec	23932 KB	824 B	100 B	03_grid_05.in
Case #19:	: Accepted	00.03 sec	25008 KB	2218 B	212 B	03_grid_06.in
Case #20:	: Accepted	00.05 sec	25304 KB	5848 B	502 B	03_grid_07.in
Case #21:	: Accepted	00.05 sec	25696 KB	11828 B	952 B	03_grid_08.in
Case #22:	: Accepted	00.18 sec	31252 KB	235554 B	20000 B	04_critical_00.in
Case #23:	: Accepted	00.18 sec	30236 KB	235547 B	20000 B	04_critical_01.in
Case #24:	: Accepted	00.29 sec	31324 KB	589171 B	20000 B	05_groups_00.in
Case #25:	: Accepted	00.25 sec	31140 KB	588903 B	20000 B	05_groups_01.in
Case #26:	: Accepted	00.24 sec	30752 KB	588841 B	20000 B	05_groups_02.in
Case #27:	: Accepted	00.22 sec	30436 KB	588937 B	20000 B	05_groups_03.in
Case #28:	: Accepted	00.20 sec	31216 KB	588885 B	20000 B	05_groups_04.in
Case #29:	: Accepted	00.06 sec	26284 KB	23552 B	1964 B	06_randmax_00.in
Case #30:	: Accepted	00.38 sec	34768 KB	588697 B	50378 B	06_randmax_01.in
Case #31:	: Accepted	00.52 sec	35500 KB	824459 B	70202 B	06_randmax_02.in
Case #32:	: Accepted	00.73 sec	36912 KB	1178206 B	100382 B	06_randmax_03.in

http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2380197#2
 */