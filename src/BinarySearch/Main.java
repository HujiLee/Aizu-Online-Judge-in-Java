package BinarySearch;
/**
 * 下午面试群硕时写的代码
 */

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Main {
    public static int binary_Search(int[] arr,int target,int startIndex,int length){
        assert (length>0);
        if(length==1){
            if(target==arr[startIndex]){
                return startIndex;
            }else{
                return -1;
            }
        }else{
            int middileIndex = (startIndex+(startIndex+length-1))/2;
            int middleValue = arr[middileIndex];
            if(target==middleValue){
                return middileIndex;
            }else if(target>middleValue){
                return binary_Search(arr, target,middileIndex+1, length-(middileIndex-startIndex+1));
            }else{
                return binary_Search(arr, target, startIndex, middileIndex-startIndex);
            }
        }


    }

    /**
     * 用循环替代递归写法
     * @param arr
     * @param target
     * @return
     */
    public static int bSearch(int[] arr,int target){
        int start = 0;
        int length = arr.length;
        while (length>1){
            int mI = (start+(start+length-1))/2;
            int mV  = arr[mI];
            if(target==mV){
                return mI;
            }else if(target>mV){
                start = mI+1;
                length = length-(mI-start+1);
            }else{
                length = mI-start;
            }
        }
        if(arr[start]==target){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,8,9};
        int i1 = binary_Search(arr,3,0,arr.length);
        int i2 = binary_Search(arr,1,0,arr.length);
        int i3 = binary_Search(arr,9,0,arr.length);
        int i4 = binary_Search(arr,8,0,arr.length);
        i1 = bSearch(arr,3);
        i2 = bSearch(arr,1);
        i3 = bSearch(arr,9);
        i4 = bSearch(arr,8);
        System.out.println();


    }
}
