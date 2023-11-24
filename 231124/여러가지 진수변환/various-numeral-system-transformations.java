import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt(), n_system = sc.nextInt(), sum = 0, idx = 0;
        int[] arr = new int[100];
        while(true){
            if(input / n_system == 0){
                arr[idx] = input % n_system;
                break;
            }
            else{
                arr[idx] = input % n_system;
                input /= n_system;
            }
            idx++;
        }

        for(int i = idx ; i >= 0 ; i--){
            System.out.print(arr[i]);
        }
    }
}