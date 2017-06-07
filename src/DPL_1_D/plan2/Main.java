package DPL_1_D.plan2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
class Debugger{
    static String list(List list){
        String s = "";
        for(Object o:list){
            s+=o;
        }
        return s;
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

    static class Solver{
        public Solver(long[] seq) {
            this.seq = seq;
        }

        final long[] seq;



        private int getNextIndex(long toBeCompared,ArrayList<Long> list,int startIndex,int length){
            assert (list.size()>0);
            //二分法选择应该插入(或修改)的位置
            if(length==1){
                if(toBeCompared>list.get(startIndex)){
                    return startIndex+1;
                }else{
                    return startIndex;
                }
            }else{
                int middle = (startIndex+(startIndex+length-1))/2;
                long middleV =list.get(middle);
                if(toBeCompared>middleV){
                    return getNextIndex(toBeCompared, list, middle+1, length-(middle+1-startIndex));
                }else if(toBeCompared==middleV){
                    return middle;
                }else{
                    //从这里可能造成无限的递归:当middle位置恰好为startIndex的时候

                    return getNextIndex(toBeCompared, list, startIndex, middle-1-startIndex+1);
                }
            }

        }
        public int getResult(){
            ArrayList<Long> list_table = new ArrayList<Long>();
            list_table.add(seq[0]);
            for(int i =1;i<seq.length;i++){
                int size = list_table.size();
                int index = getNextIndex(seq[i],list_table,0,size);
                if(index<size){
                    list_table.set(index,seq[i]);
                }else {
                    list_table.add(seq[i]);
                }
            }


            return list_table.size();
        }
    }
}
/**
 Case #	Verdict	CPU Time	Memory	In	Out	Case Name
 Case #1:	: Accepted	00.03 sec	23968 KB	12 B	2 B	00_sample_00.in
 Case #2:	: Accepted	00.03 sec	24060 KB	8 B	2 B	00_sample_01.in
 Case #3:	: Accepted	00.03 sec	23980 KB	6 B	2 B	01_small_00.in
 Case #4:	: Accepted	00.03 sec	24196 KB	6 B	2 B	01_small_01.in
 Case #5:	: Accepted	00.03 sec	24052 KB	8 B	2 B	01_small_02.in
 Case #6:	: Accepted	00.03 sec	24216 KB	8 B	2 B	01_small_03.in
 Case #7:	: Accepted	00.02 sec	23824 KB	10 B	2 B	01_small_04.in
 Case #8:	: Accepted	00.02 sec	24048 KB	12 B	2 B	01_small_05.in
 Case #9:	: Accepted	00.03 sec	23996 KB	33 B	2 B	01_small_06.in
 Case #10:	: Accepted	00.03 sec	24076 KB	14 B	2 B	01_small_07.in
 Case #11:	: Runtime Error	-	-	103 B	2 B	02_rand_00.in
 */
/*
rand-in:
50
3
3
2
9
0
8
2
6
6
9
1
1
3
5
8
3
0
6
9
2
7
7
2
8
0
3
9
2
4
9
1
7
0
4
5
0
4
0
2
4
3
1
0
6
6
1
9
7
5
1

rand-out:8
 */
