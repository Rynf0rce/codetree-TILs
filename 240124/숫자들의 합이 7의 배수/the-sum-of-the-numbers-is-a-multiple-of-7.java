import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 50000;
    public static int[] arr = new int[MAX_LENGTH];
    public static int[] prefixArr = new int[MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        prefixArr[0] = arr[0];
        for(int i = 1 ; i < N ; i++){
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        int maxVal = 0;
        for(int i = 1 ; i < N ; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
                if( (prefixArr[i] - prefixArr[j]) % 7 == 0 ){
                    maxVal = Math.max(maxVal, i - j);
                }
            }
        }
        
        System.out.println(maxVal);
    }
}