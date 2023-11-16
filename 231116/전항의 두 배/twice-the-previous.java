import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();

        for(int i = 0 ; i < arr.length ; i++){
            if(i > 1){
                arr[i] = arr[i-1] + 2* arr[i-2];
            } 
            System.out.print(arr[i] + " ");
        }
    }
}