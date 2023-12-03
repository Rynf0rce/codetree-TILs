import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length - 1 ; i++){
            int cnt = 1;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] <= arr[i] + K){
                    cnt++;
                }
                else{
                    break;
                }
            }
            maxVal = Math.max(maxVal, cnt);
        }
        System.out.println(maxVal);
    }
}