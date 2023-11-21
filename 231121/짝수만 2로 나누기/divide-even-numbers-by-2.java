import java.util.*;

public class Main {
    public static void conFuc(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 2 == 0){
                arr[i] /= 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        conFuc(arr);

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}