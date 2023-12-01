import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        
        int maxval = Integer.MIN_VALUE;
        for(int i = 1 ; i <= 100 ; i++){
            int cnt = 0;
            for(int j = 0 ; j < arr.length - 1 ; j++){
                for(int k = j + 1 ; k < arr.length ; k++){
                    if( (i - arr[j]) == (arr[k] - i) ){
                        cnt++;
                    }
                }
            }
            maxval = Math.max(maxval, cnt);
        }
        System.out.println(maxval);
    }
}