import java.util.*;
public class Main {
    public static final int MAX_INPUT = 100;
    public static int[] arr = new int[MAX_INPUT];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        boolean sorted = false;
        int cnt = n;
        while(!sorted){
            sorted = true;
            for(int i = 1 ; i < cnt ; i++){
                if(arr[i-1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    sorted = false;
                }
            }
            cnt--;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}