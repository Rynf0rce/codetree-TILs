import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int num = 0;
        int maxVal = -1000;
        for(int i = 0 ; i < n ; i++){
            num += arr[i];
            maxVal = Math.max(maxVal, num);
            if(num < 0){
                num = 0;
            }
        }

        System.out.println(maxVal);
    }
}