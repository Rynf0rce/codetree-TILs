import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int maxVal = -1;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i - K ; j <= i + K ; j++){
                if(j < 0 || j >= arr.length || i == j){
                    continue;
                }
                if(arr[i] == arr[j]){
                    maxVal = Math.max(maxVal, arr[i]);
                    break;
                }
            }
        }
        System.out.println(maxVal);
    }
}