import java.util.Arrays;

public class moveTartget {
    public static void main(String []args){
        int [] arr = new int[]{1,0,2,2,5,2,6,5,2,0,0};
        moveTarget(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    /*
     *  move target in the array to the end, keeping the order of other elements
     */
    public static void moveTarget(int[] arr, int target){
        if( arr == null)
            return;
        int i = arr.length-1, j = arr.length-1; // i points at first non-target elem.
        // 10,2,5,2,6,0,0,2  target 0      // j first target elem.
        //              j i
        out:
        // invariant: elements to j right are sorted.
        // i is the index where arr[j]=0 will be place in.
        while( j>0){

            while(arr[i]==target)
                i--;
            while(arr[j]!=target) {
                j--;
                if(j<0)
                    break out;
            }
            if(i>j) {
                // swap elem
                int idx = j;
                while (idx < i) {
                    int temp = arr[idx];
                    arr[idx] = arr[idx + 1];
                    arr[idx + 1] = temp;
                    idx++;
                }
            }else  // if j<=i, arr[ j+1 ,end] is sorted, only need to sorted arr[0,j]
                j = i;
        }
    }
}
