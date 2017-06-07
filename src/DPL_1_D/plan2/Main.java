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
                    if(middle==startIndex){
                        return middle;
                    }
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
/*
Run#	提出者	問題	結果	%	言語	時間	メモリ	コード長	提出日時
2358981	Hujimiya	DPL_1_D: Longest Increasing Subsequence	: Accepted	30/30	JAVA	00:25 s	64392 KB	3739 B	2017-06-07 23:58
 */
/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2358981#2
 */