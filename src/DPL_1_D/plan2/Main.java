package DPL_1_D.plan2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/6/7 0007.
 */



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
                if(toBeCompared>=list.get(startIndex)){
                    return startIndex+1;
                }else{
                    return startIndex;
                }
            }else{
                int middle = (startIndex+(startIndex+length-1))/2;
                if(toBeCompared>=list.get(middle)){
                    return getNextIndex(toBeCompared, list, middle+1, length-(middle+1-startIndex));
                }else{
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
