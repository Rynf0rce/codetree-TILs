import java.util.*;

public class Main {
    public static char[] arr;
    public static int minimumDistance(){
        int[] idxArr = new int[arr.length];
        int cnt = 0, minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '1'){
                idxArr[cnt++] = i;
            }
        }

        for(int i = 1 ; i < cnt ; i++){
            minVal = Math.min(minVal, idxArr[i] - idxArr[i-1]);
        }
        if(minVal == Integer.MAX_VALUE){
            minVal = 0;
        }
        return minVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = sc.next().toCharArray();

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i] == '1'){
                continue;
            }
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[j] == '1'){
                    continue;
                }
                arr[i] = '1';
                arr[j] = '1';
                maxVal = Math.max(maxVal, minimumDistance());
                arr[i] = '0';
                arr[j] = '0';
            }
        }
        System.out.println(maxVal);
    }
}