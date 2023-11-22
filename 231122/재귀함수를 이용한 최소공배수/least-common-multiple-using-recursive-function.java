import java.util.*;

public class Main {
    public static int conFnc(int[] arr, int n){
        boolean triger = false;
        boolean proTriger = false;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= n){
                triger = true;
                break;
            }
        }

        if(triger){
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] % n == 0){
                    arr[i] /= n;
                    proTriger = true;
                }
            }

            if(proTriger){
                return conFnc(arr, n+1) * n;
            }
            else{
                return conFnc(arr, n+1);
            }  
        }
        else{
            int product = 1;
            for(int i = 0; i < arr.length ; i++){
                product *= arr[i];
            }
            return product;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(conFnc(arr, 1));
    }
}