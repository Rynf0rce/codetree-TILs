import java.util.*;

public class Main {
    public static int[] arr = new int[3];
    public static void sort(){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = 1 ; j < arr.length ; j++){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = sc.nextInt();
        }

        sort();

        for(int i = arr[0] ; i <= arr[2] ; i++){
            if(i == arr[1]){
                continue;
            }
            for(int j = 1 ; j <= 9 ; j++){
                System.out.printf("%d * %d = %d\n",i, j, i * j);
            }
        }

        
    }
}