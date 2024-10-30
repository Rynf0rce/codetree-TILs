import java.util.*;

public class Main {
    public static int[] arr = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = 2;
        if(arr[2] - arr[1] == 1){
            ans--;
        }
        
        if(arr[1] - arr[0] == 1){
            ans--;
        }

        if(arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2){
            ans = 1;
        }
        System.out.print(ans);
    }
}