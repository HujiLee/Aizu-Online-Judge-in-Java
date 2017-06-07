package DPL_1_B;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 0-1 Knapsack Problem
 * 0-1背包问题
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_B
 */
class Solver{
    final Item[] items;
    final int capacityOfKnapsack;
    int[][] table;
    public Solver(Item[] items, int capacityOfKnapsack) {
        this.items = items;
        this.capacityOfKnapsack = capacityOfKnapsack;
        table = new int[items.length+1][capacityOfKnapsack+1];
        for(int i =1;i<=items.length;i++){
            for(int j = 1;j<=capacityOfKnapsack;j++){
                table[i][j]=-1;
            }
        }
    }

    private int getMaxValue(int indexForItem,int capacity){
        if(table[indexForItem][capacity]<0){
            if(items[indexForItem-1].weight>capacity){
                table[indexForItem][capacity]=getMaxValue(indexForItem-1, capacity);
            }else{
                table[indexForItem][capacity]=Math.max(
                        getMaxValue(indexForItem-1, capacity),
                        items[indexForItem-1].value+getMaxValue(indexForItem-1, capacity-items[indexForItem-1].weight)
                );
            }

        }
        return table[indexForItem][capacity];
    }

    public int getResult(){
        return getMaxValue(items.length,capacityOfKnapsack);
    }

}
final class Item{
    final int value,weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(System.in);
    static int getInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }
    public static void main(String[] args) throws IOException {
        int countItems = getInt();
        int capacity = getInt();
        Item[] items = new Item[countItems];
        for(int i = 0;i<countItems;i++){
            items[i] = new Item(getInt(),getInt());
        }
        Solver solver = new Solver(items,capacity);
        System.out.println(solver.getResult());

    }
}
