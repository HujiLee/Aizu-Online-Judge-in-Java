package DSL_1_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
class Solver {

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
        return sets[x]==sets[y];
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
        Solver solver = new Solver(n);
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
Judge: 2/32	JAVA	CPU: 00.03 sec	Memory: 24008 KB	Length: 2176 B	2017-06-20 00:57	2017-06-20 00:57
Results for testcases
Case #	Verdict	CPU Time	Memory	In	Out	Case Name
Case #1:	: Accepted	00.03 sec	23948 KB	77 B	16 B	00_small_00.in
Case #2:	: Accepted	00.03 sec	23968 KB	113 B	12 B	00_small_01.in
Case #3:	: Wrong Answer	00.03 sec	24008 KB	186 B	28 B	01_rand_00.in

http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2380167#2

 */