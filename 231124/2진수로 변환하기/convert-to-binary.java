import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt(), cnt = 0;
        int[] arr = new int[100];
        while(true){
            arr[cnt++] = input % 2;
            input /= 2;
            if(input == 0){
                break;
            }
        }

        for(int i = cnt - 1; i >= 0 ; i--){
            System.out.print(arr[i]);
        }
    }
}