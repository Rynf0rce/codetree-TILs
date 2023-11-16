import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        double average = 0;
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] >= 250){
                if(sum == 0){
                    average = 0;
                }
                else{
                    average = (double) sum / i;
                }
                break;
            }
            else{
                sum += arr[i];
            }
        }
        System.out.printf("%d %.1f", sum, average);
    }
}