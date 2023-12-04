import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100 * 100;
    public static int[] arr;
    public static boolean conFnc(int maxVal, int boundaryNum){
        int cnt = 0;
        int currentVal = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > maxVal || cnt > boundaryNum){
                return false;
            }
            currentVal += arr[i];

            if(currentVal > maxVal){
                currentVal = arr[i];
                cnt++;
            }
        }
        return (cnt == boundaryNum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), maxVal = 0;;
        arr = new int[n];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }

        int minOfMax = 0;
        for(int i = 1 ; i <= MAX_RANGE ; i++){
            if(conFnc(i,m-1)){
                minOfMax = i;
                break;
            }
        }
        if(minOfMax == 0){
            minOfMax = maxVal;
        }
        System.out.println(minOfMax);
    }
}