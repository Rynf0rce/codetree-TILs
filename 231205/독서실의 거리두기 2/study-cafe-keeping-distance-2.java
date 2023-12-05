import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), idx = 0, cnt = 0 ;
        char[] arr = sc.next().toCharArray();
        int[] rangeArr = new int[N];

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '1'){
                rangeArr[idx++] = cnt;
                cnt = 0;
            }
            if(i == arr.length - 1){
                rangeArr[idx++] = cnt;
            }
            cnt++;
        }

        int start = 0, end = 0, maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < idx ; i++){
            int minVal = Integer.MAX_VALUE;
            if(i == 0 || i == idx - 1){
                minVal = Math.min(minVal, rangeArr[i]);
            }
            for(int j = 1 ; j < idx -1 ; j++){
                int currentVal = rangeArr[j];
                if(j == i){
                    currentVal /= 2;
                }
                minVal = Math.min(minVal, currentVal);
            }
            maxVal = Math.max(maxVal, minVal);
        }
        System.out.println(maxVal);
    }
}