import java.util.*;

public class Main {
    public static int conFnc(int[] arr){
        int n = 2, product = 1;
        boolean triger = false;
        boolean behaviour = true;
        while(behaviour){
            behaviour = false;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] % n == 0){
                    arr[i] /= n;
                    triger = true;
                }
                if(arr[i] > n){
                    behaviour = true;
                }
            }
            if(triger){
                return conFnc(arr) * n;
            }
            n++;
        }
        for(int i = 0; i < arr.length ; i++){
            product *= arr[i];
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(conFnc(arr));
    }
}