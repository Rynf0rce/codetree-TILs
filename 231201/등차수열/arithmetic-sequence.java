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

        
        int cnt = 0;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                for(int k = arr[i] + 1 ; k < arr[j] ; k++){
                    if((k - arr[i]) == (arr[j] - k)){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}