import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), flag = 0;
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = n * (i+1);
        }


        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
            if(arr[i] % 5 == 0){
                if(flag == 1){
                    break;
                }
                flag++;
            }
            else{
                flag = 0;
            }
        }
    }
}