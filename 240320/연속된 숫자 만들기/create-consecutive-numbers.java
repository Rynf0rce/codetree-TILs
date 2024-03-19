import java.util.*;

public class Main {
    public static int[] arr = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if(arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1){
            System.out.println(0);
        }
        else if(arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2){
            System.out.println(1);
        }
        else{
            System.out.println(2);
        }

        int maxCnt = Math.max(arr[1] - arr[0] - 1, arr[2] - arr[1] - 1);
        System.out.print(maxCnt);
    }
}