import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int j = 0 ; j < arr.length ; j++){
            if(arr[j] % 3 == 0){
                System.out.print(arr[j-1]);
                break;
            }
        }
    }
}