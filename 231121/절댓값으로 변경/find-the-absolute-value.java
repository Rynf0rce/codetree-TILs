import java.util.*;

public class Main {
    public static void arrAbsol(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < 0 ){
                arr[i] *= -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        arrAbsol(arr);

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}