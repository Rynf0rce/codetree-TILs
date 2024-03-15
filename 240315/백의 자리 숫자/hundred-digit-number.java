import java.util.*;
public class Main {
    public static int[] arr = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            arr[num / 100]++;
        }

        for(int i = 0 ; i <= 9 ; i++){
            if(arr[i] == 0){
                continue;
            }
            System.out.printf("%d - %d\n", i, arr[i]);
        }
    }
}