import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int[] arr = new int[MAX_LENGTH];
    public static final int[] leftArr = new int[MAX_LENGTH];
    public static final int[] rightArr = new int[MAX_LENGTH];

    public static int combination(int i){
        return ( i * (i - 1) * (i - 2) ) / ( 3 * 2 * 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        leftArr[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            leftArr[i] = arr[i] + leftArr[i - 1];
        }

        rightArr[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0 ; i--){
            rightArr[i] = rightArr[i + 1] + arr[i];
        }

        int output = 0;

        for(int i = 0 ; i < n - 1 ; i++){
            if(leftArr[i] * 3 == rightArr[i + 1]){
                for(int j = i + 1 ; j < n - 1 ; j++){
                    if(leftArr[j] == rightArr[j + 1]){
                        for(int k = j + 1 ; k < n - 1 ; k++){
                            if(leftArr[k] == rightArr[k + 1] * 3){
                                output++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(output);
    }
}