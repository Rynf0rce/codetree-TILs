import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr = new int[MAX_RANGE + 1];
    public static int[] temp = new int[MAX_RANGE + 1];
    public static int del(int a1, int a2, int range){
        Arrays.fill(temp, 0);
        int tempIdx = 1;
        for(int i = a1 ; i <= a2 ; i++){
            arr[i] = 0;
        }

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] != 0){
                temp[tempIdx++] = arr[i];
            }
        }

        range = tempIdx - 1;

        for(int i = 1 ; i < arr.length ; i++ ){
            arr[i] = temp[i];
        }
        
        return range;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < 2 ; i++){
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            n = del(a1, a2, n);
        }

        System.out.println(n);

        for(int i = 1 ; i <= n ; i++){
            System.out.println(arr[i]);
        }
    }
}