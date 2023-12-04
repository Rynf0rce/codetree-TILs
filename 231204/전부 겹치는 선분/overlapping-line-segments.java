import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a ; j <= b ; j++){
                arr[j]++;
            }
        }

        boolean output = false;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == n){
                output = true;
            }
        }
        System.out.println(output ? "Yes" : "No");
    }
}