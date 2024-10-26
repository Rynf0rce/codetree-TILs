import java.util.*;

public class Main {
    public static final int MAX_HOUSE = 100;
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[MAX_HOUSE];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int min = INT_MAX;
        int temp = 0;
        for(int i = 0 ; i < n ; i++){
            temp = 0;
            for(int j = 0 ; j < n ; j++){
                temp += arr[j] * Math.abs(i-j);
            }
            if(temp < min){
                min = temp;
            }
        }
        System.out.println(min);
    }
}