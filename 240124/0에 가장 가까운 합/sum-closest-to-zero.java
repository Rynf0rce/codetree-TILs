import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MAX_INT = (int) 1e9;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);

        int j = n - 1;
        long minVal = MAX_LENGTH * MAX_INT + 1;
        for(int i = 0 ; i < n ; i++){
            while(j > i && Math.abs(arr[i] + arr[j]) < minVal){
                minVal = Math.abs(arr[i] + arr[j]);
                j--;
            }
        }

        System.out.println(minVal + "");
    }
}