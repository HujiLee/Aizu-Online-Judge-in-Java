package ALDS1_1_B;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

import java.util.Scanner;

/**
 * @anchor http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_B
 */
public class Main {
    static  Scanner scanner = new Scanner(System.in);
    static int gcd(int x,int y){
        if(y==0){
            return x;
        }
        if(x>y){
            return gcd(y,x%y);
        }
        if(y>x){
            return gcd(y, x);
        }

        return -1;
    }
    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a,b));

    }
}
