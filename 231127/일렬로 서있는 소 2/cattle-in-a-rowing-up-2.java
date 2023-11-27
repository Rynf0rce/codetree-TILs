import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                for(int k = j + 1 ; k < arr.length ; k++){
                    if(arr[j] >= arr[i] && arr[k] >= arr[j]){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}